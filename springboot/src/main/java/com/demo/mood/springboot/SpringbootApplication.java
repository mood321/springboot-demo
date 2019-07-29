package com.demo.mood.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/** 定义扫描  用于单个测试*/
@ComponentScan({"com.demo.mood.springboot.async","com.demo.mood.springboot.utils"})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
