package com.example.wenmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan(basePackages = "com.example.wenmanager.mapper")
public class WenManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WenManagerApplication.class, args);
    }

}
