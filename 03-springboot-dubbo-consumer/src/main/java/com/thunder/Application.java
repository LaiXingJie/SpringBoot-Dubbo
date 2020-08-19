package com.thunder;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration //Dubbo开启自动注入
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
