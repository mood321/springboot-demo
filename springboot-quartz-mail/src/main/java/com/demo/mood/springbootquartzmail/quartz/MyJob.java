package com.demo.mood.springbootquartzmail.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @Created by mood321
 * @Date 2019/7/31 0031 22:34
 * @Description TODO
 */
@Component
public class MyJob extends ScheduledJob {

    /**
     * 五秒钟跑一次
     *
     * @return
     */
    @Override
    public String getCron() {
        return "0/5 * * * * ?";
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("job1 is running ************************");

    }
}
