package com.zz.bamboo.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
@MapperScan({"com.zz.bamboo.admin.mapper"})
public class AdminApplication {

    public static void main(String[] args) {
        System.out.println("dd");
        SpringApplication.run(AdminApplication.class, args);
    }

}
