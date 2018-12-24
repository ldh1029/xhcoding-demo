package com.example.demo.config;

import com.example.demo.filter.TestFilter;
import com.example.demo.security.JwtInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/user/show/*");
        super.addInterceptors(registry);
    }

    @Bean
    public HandlerInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

//    @Bean
//    public FilterRegistrationBean otherOpenApiFilter() {
//
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.addUrlPatterns("/*");
//        registration.setFilter(new TestFilter());
//        return registration;
//    }
}
