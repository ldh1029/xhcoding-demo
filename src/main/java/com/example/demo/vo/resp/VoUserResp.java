package com.example.demo.vo.resp;

import com.example.demo.core.VoBaseResp;
import lombok.Data;

@Data
public class VoUserResp extends VoBaseResp {
    private String account;
    private String password;
}
