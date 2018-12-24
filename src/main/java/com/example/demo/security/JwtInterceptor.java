package com.example.demo.security;

import com.example.demo.helper.JwtTokenHelper;
import com.example.demo.helper.RedisHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Configuration
public class JwtInterceptor implements HandlerInterceptor {

    @Value("${jwt.header}")
    private String header;
    @Autowired
    RedisHelper redisHelper;

    @Autowired
    JwtTokenHelper jwtTokenHelper;

    private List<String> excludeUrl = Lists.newArrayList();

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取token 验证身份信息

        System.out.println(header);
        String token = jwtTokenHelper.getToken(httpServletRequest);
        if (ObjectUtils.isEmpty(token)) {
            throw new BadCredentialsException("无效的token!");
        }
        String username = jwtTokenHelper.getUsernameFromToken(token);
        String s = redisHelper.get(username, null);
        Preconditions.checkNotNull(s, "无效的token!");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
