package com.training.onlineeduplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.training.onlineeduplatform.mapper")
@EnableCaching
public class OnlineEduPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineEduPlatformApplication.class, args);
    }

}
