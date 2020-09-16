package com.tdxk.dp;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author lin.
 */
@SpringBootApplication
@EnableAsync
@MapperScan("com.tdxk.dp.mapper")
public class DpApplication {
    public static void main(String[] args) {
        SpringApplication.run(DpApplication.class, args);
    }
}
