package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*配置：扫描mapper的接口包*/
@MapperScan(basePackages = "com.study.model.mapper")
public class Springboot02005Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02005Application.class, args);
    }

}
