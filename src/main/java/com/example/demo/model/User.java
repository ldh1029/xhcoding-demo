package com.example.demo.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@TableName("users")
@Data
public class User {
    @Id
    private Integer id;

    @TableField("account")
    private String account;

    @TableField("account_type")
    private String accountType;

    @TableField("password")
    private String password;

    @TableField("age")
    private Integer age;

    @TableField("createDate")
    private Date createdate;

    @TableField("updateDate")
    private Date updatedate;

    public User(String account, String accountType, String password, Integer age) {
        this.account = account;
        this.accountType = accountType;
        this.password = password;
        this.age = age;
    }

    public User() {
    }
}