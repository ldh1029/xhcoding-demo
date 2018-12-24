package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.constants.MqConfig;
import com.example.demo.constants.MqQueueEnum;
import com.example.demo.constants.MqTagEnum;
import com.example.demo.core.VoBaseResp;
import com.example.demo.helper.MqHelper;
import com.example.demo.helper.RandomUtil;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.req.VoUserReq;
import com.example.demo.vo.resp.VoUserListWrap;
import com.example.demo.vo.resp.VoUserResp;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.RandomUtils;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.get.GetField;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MqHelper mqHelper;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    RestHighLevelClient highLevelClient;

    @Override
    public VoUserResp selectUser(String id) {
        VoUserResp voUserResp = VoBaseResp.ok("查询成功!", VoUserResp.class);
        User user = new User();
        user.setId(Integer.valueOf(id));
        user = userMapper.selectOne(user);
        Preconditions.checkNotNull(user, "用户信息为空");
        BeanUtils.copyProperties(user, voUserResp);
        return voUserResp;
    }

    @Override
    public VoUserListWrap selectAllUser(VoUserReq voUserReq) {
        List<User> users = userMapper.selectPage(new Page<>(voUserReq.getPage(), voUserReq.getSize()), new EntityWrapper<>());
        Preconditions.checkNotNull(users, "用户集合为空!");
        VoUserListWrap voUserListWrap = VoBaseResp.ok("查询成功", VoUserListWrap.class);
        users.stream().forEach(user -> {
            User tempUser = new User();
            BeanUtils.copyProperties(user, tempUser);
            voUserListWrap.getList().add(tempUser);
        });
        return voUserListWrap;
    }

    @Override
    public VoBaseResp addUser() {
        User user = new User();
        user.setAccount(RandomUtil.getRandomString(8));
        user.setPassword(passwordEncoder.encode(RandomUtil.getRandomString(6)));
        user.setId(9);
        user.setAge(RandomUtils.nextInt());
        user.setCreatedate(new Date());
        user.setUpdatedate(new Date());
        Integer result = userMapper.insert(user);
        if (result == 0) {
            VoBaseResp.error(HttpStatus.OK.value(), "添加用户失败!");
        }
        return VoBaseResp.ok("添加用户成功!");
    }

    @Override
    public VoBaseResp insertUser(User user) {

        return VoBaseResp.ok("添加用户成功!");
    }

    @Override
    public VoUserListWrap queryUser(String account) {
        Preconditions.checkNotNull(account, "account is null");
        VoUserListWrap voUserResp = VoBaseResp.ok("查询成功!", VoUserListWrap.class);
        return voUserResp;
    }

    @Override
    public VoBaseResp notice() {
        MqConfig mqConfig = new MqConfig();
        mqConfig.setQueue(MqQueueEnum.RABBITMQ_NOTICE);
        mqConfig.setTag(MqTagEnum.SMS_NOTICE);
        ImmutableMap msg = ImmutableMap.of("msg", "test notice");
        mqConfig.setMsg(msg);
        mqHelper.convertAndSend(mqConfig);
        return VoBaseResp.ok("消息发送成功!");
    }

    @Override
    public VoBaseResp testRestClient() {
        SearchRequest searchRequest = new SearchRequest("hotel_info_dev");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("hotelName", "酒清乐园"));
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse response = highLevelClient.search(searchRequest);
            Arrays.stream(response.getHits().getHits())
                    .forEach(i -> {
                        System.out.println(i.getSource());
                    });
            System.out.println(response.getHits().totalHits);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return null;
//        try {
//            IndexRequest indexRequest = new IndexRequest("user", "account", "123").source(jsonBuilder()
//                    .startObject()
//                    .field("id", "18566230615")
//                    .field("title", "软件开发")
//                    .field("content", "bobo")
//                    .field("type", "java")
//                    .endObject()).timeout(TimeValue.timeValueMinutes(10));
//            highLevelClient.index(indexRequest);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        GetRequest getRequest = new GetRequest("hotel_info_dev", "", "01a4f14edc27410bafa41fb1bd99bb12");
//        Map<String, Object> source = null;
//        try {
//            GetResponse fields = highLevelClient.get(getRequest);
//            source = fields.getSource();
//            for (String key : source.keySet()) {
//                System.out.println(source.get(key));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return VoBaseResp.ok("查询成功");
    }
}
