package com.example.demo.listener;

import com.example.demo.constants.MqConfig;
import com.example.demo.constants.MqQueueEnumContants;
import com.example.demo.constants.MqTagEnum;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class NoticeListener {
    Gson gson = new Gson();
    @RabbitListener(queues = "notice")
    @RabbitHandler
    public void process(byte[] json) {
        String message = new String(json);
        Preconditions.checkNotNull(message, "message is empty");
        Map<String, Object> body = gson.fromJson(message, new TypeToken<Map<String, Object>>() {
        }.getType());
        Preconditions.checkNotNull(body.get(MqConfig.MSG_TAG), "BorrowListener process tag is empty ");
        Preconditions.checkNotNull(body.get(MqConfig.MSG_BODY), "BorrowListener process body is empty ");
        String tag = body.get(MqConfig.MSG_TAG).toString();
        Map<String, String> msg = (Map<String, String>) body.get(MqConfig.MSG_BODY);

        if (tag.equals(MqTagEnum.SMS_NOTICE.getValue())) {
            try {
                System.out.println("队列成功消费消息");
            } catch (Throwable e) {
                log.error("赠送流量券异常：", e);
            }
        } else {
            log.error("Listener error：未匹配到tag" + tag);
        }
    }
}
