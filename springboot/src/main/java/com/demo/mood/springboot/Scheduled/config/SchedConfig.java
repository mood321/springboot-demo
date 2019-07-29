package com.demo.mood.springboot.Scheduled.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Description 开启Springboot 对定时任务支持
 * @Date 2019/7/29 0029 23:01
 * @Created by mood321
 */
@EnableScheduling
@Configuration
public class SchedConfig {



}
