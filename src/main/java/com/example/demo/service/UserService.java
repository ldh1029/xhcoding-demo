package com.example.demo.service;

import com.example.demo.core.VoBaseResp;
import com.example.demo.model.User;
import com.example.demo.vo.req.VoUserReq;
import com.example.demo.vo.resp.VoUserListWrap;
import com.example.demo.vo.resp.VoUserResp;

public interface UserService {

    VoUserResp selectUser(String id);

    VoUserListWrap selectAllUser(VoUserReq voUserReq);

    VoBaseResp addUser();

    VoBaseResp insertUser(User user);

    VoUserListWrap queryUser(String account);

    VoBaseResp notice();

    VoBaseResp testRestClient();

}
