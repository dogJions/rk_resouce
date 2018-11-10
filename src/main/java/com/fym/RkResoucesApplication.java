package com.fym;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.fym.dao")
@EnableTransactionManagement
public class RkResoucesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RkResoucesApplication.class, args);
    }
}
