package com.example.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.config.DBTypeEnum;
import com.example.demo.config.DataSourceKeyHolder;
import com.example.demo.core.VoBaseResp;
import com.example.demo.mapper.HotelMapper;
import com.example.demo.model.Hotel;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.req.VoUserReq;
import com.example.demo.vo.resp.VoUserListWrap;
import com.example.demo.vo.resp.VoUserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private HotelMapper hotelMapper;

    @GetMapping("/show/{id}")
    public VoUserResp show(@PathVariable(value = "id") String id) {
        return userService.selectUser(id);
    }

    @GetMapping("/showAll/{page}/{size}")
    public VoUserListWrap showAll(@ModelAttribute @Valid VoUserReq voUserReq) {
        return userService.selectAllUser(voUserReq);
    }

    @GetMapping("/addUser")
    public VoBaseResp addUser() {
        return userService.addUser();
    }

    @GetMapping("/test")
    public void test() {
        DataSourceKeyHolder.set(DBTypeEnum.PRIMARY);
        List<Hotel> hotels = hotelMapper.selectList(new EntityWrapper<>());
    }

    @PostMapping("/insertUser")
    public VoBaseResp insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @GetMapping("/queryUser/{account}")
    public VoUserListWrap queryUser(@PathVariable String account) {
        return userService.queryUser(account);
    }

    @GetMapping("/pub/notice")
    public VoBaseResp notice(){
        return userService.notice();
    }

    @GetMapping("/es")
    public VoBaseResp testRestClient(){
           return userService.testRestClient();
    }

}
