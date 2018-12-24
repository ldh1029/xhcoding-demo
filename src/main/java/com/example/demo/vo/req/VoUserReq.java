package com.example.demo.vo.req;

import com.example.demo.core.VoBaseReq;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class VoUserReq extends VoBaseReq {
    @NotBlank(message = "当前页不能为空!")
    private Integer page;
    @NotBlank(message = "页面尺寸不能为空!")
    private Integer size;
}
