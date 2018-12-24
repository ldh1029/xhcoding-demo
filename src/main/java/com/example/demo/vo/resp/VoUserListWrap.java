package com.example.demo.vo.resp;

import com.example.demo.core.VoBaseResp;
import com.example.demo.model.User;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class VoUserListWrap extends VoBaseResp {
    private List<User> list = Lists.newArrayList();
}
