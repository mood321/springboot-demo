package com.demo.mood.springboot.CommandLineRunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author mood321
 * @Des :
 *         随着springboot  启动完成  启动的任务
 *           比如:启动打开浏览器
 *         如果有多个 @Order() 排序
 */

@Component
@Slf4j
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("Springboot 启动任务");
    }
}
