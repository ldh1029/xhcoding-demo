package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@EnableSwagger2
@EnableScheduling
@EnableWebMvc
public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        System.out.println(run);
    }
}
