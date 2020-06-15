package com.hysz.sop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hysz.sop.mapper")
public class SopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SopApplication.class, args);
    }

}
