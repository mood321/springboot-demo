package com.demo.mood.springbootquartzmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/** 自定义扫描路径 用于单独模块*/
//@ComponentScan(value = "com.demo.mood.springbootquartzmail.quartz")
@ComponentScan(value = "com.demo.mood.springbootquartzmail.mail")
public class SpringbootQuartzMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootQuartzMailApplication.class, args);
    }

}
