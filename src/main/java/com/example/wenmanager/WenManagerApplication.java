package com.example.wenmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@MapperScan(basePackages = "com.example.wenmanager.mapper")
public class WenManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WenManagerApplication.class, args);
    }

}
