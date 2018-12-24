package com.example.demo.config;

/**
 * 数据源的key值
 * 多个数据库的类型
 * 配合动态调用不同的数据库
 * @see DataSourceKeyHolder
 */
public enum DBTypeEnum {
    /**
     *  tripdata 开发库
     */
    PRIMARY("tripdata"),
    /**
     *  wangh 本地库
     */
    FOLLOW("qunar");


    private String value;
    DBTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
