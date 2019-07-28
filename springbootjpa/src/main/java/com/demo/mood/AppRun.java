package com.demo.mood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.demo.mood.pojo"})
public class AppRun  {
    public static void main(String[] args) {
        SpringApplication.run(AppRun.class,args);
    }
}
