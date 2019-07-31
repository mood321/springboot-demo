package com.demo.mood.springbootquartzmail.quartz.config;

import com.demo.mood.springbootquartzmail.quartz.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Created by mood321
 * @Date 2019/7/31 0031 22:13
 * @Description  配置quartz  和通过ApplicationListener 监听启动
 */

@Configuration
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    public TaskManager taskManager;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            taskManager.executeTasks();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        return schedulerFactoryBean;
    }

}
