package com.demo.mood.springboot.Scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Created by mood321
 * @Date 2019/7/29 0029 23:46
 * @Description  四种模式 参数和线程池定时任务参不多
 *           一种是cornexpression。
 *
 * 　　　　一种是Rate/Delay表达式（毫秒值）：
 *
 * 　　　　　　@Scheduled(fixedRate = 6000)：上一次开始执行时间点后每隔6秒执行一次。
 *
 * 　　　　　　@Scheduled(fixedDelay = 6000)：上一次执行完毕时间点之后6秒再执行。
 *
 * 　　　　　　@Scheduled(initialDelay=1000, fixedRate=6000)：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次。
 *
 */
@Slf4j
@Component
public class ScheduledJob {
    @Scheduled(fixedRate = 5000)
    public void printHello(){
        log.info("====================Hello World 2019=====================");
    }

    @Scheduled(cron = "0 05 16 * * ?")
    public void printNow(){
        log.info("====================北京时间:{}=====================", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    }
}
