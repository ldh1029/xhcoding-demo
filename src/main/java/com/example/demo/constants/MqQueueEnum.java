package com.example.demo.constants;

/**
 * Created by Max on 17/5/26.
 */
public enum MqQueueEnum {
    RABBITMQ_SMS(MqQueueEnumContants.RABBITMQ_SMS),
    RABBITMQ_EMAIL(MqQueueEnumContants.RABBITMQ_EMAIL),
    RABBITMQ_NOTICE(MqQueueEnumContants.RABBITMQ_NOTICE);

    private String value;

    MqQueueEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


