package com.example.demo.mapper;

import com.example.demo.model.User;

import java.util.List;

public interface UserRepository {

    /**
     * 根据账号查询用户
     * @return
     */
    List<User> findByAccount(String account);
}
