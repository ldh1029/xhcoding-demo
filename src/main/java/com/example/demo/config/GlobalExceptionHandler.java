package com.example.demo.config;

import com.example.demo.core.VoBaseResp;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public VoBaseResp exception(Exception e) {
        return VoBaseResp.error(VoBaseResp.ERROR, e.getMessage());
    }
}
