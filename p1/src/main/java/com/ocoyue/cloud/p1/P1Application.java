package com.ocoyue.cloud.p1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @MapperScan("com.ocoyue.cloud.p1.mapper")
@MapperScan("com.ocoyue.cloud.p1.mapper")
public class P1Application {

    public static void main(String[] args) {
        SpringApplication.run(P1Application.class, args);
    }

}
