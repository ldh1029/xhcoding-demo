package com.example.demo.constants;

/**
 * Created by Max on 17/5/26.
 */
public enum MqTagEnum {
    SMS_NOTICE("SMS_NOTICE");

    private String value;

    private MqTagEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // 普通方法
    public static MqTagEnum getMqTagEnum(String type) {
        for (MqTagEnum c : MqTagEnum.values()) {
            if (c.getValue().equals(type)) {
                return c;
            }
        }
        return null;
    }
}

