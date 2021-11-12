package com.tanjiaming99;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.tanjiaming99.mapper")
@SpringBootApplication
public class EasyBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyBlogApplication.class, args);
    }

}
