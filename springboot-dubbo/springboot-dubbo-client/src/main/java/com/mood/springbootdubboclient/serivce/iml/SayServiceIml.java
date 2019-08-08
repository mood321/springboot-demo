package com.mood.springbootdubboclient.serivce.iml;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mood.springbootdubbo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Created by mood321
 * @Date 2019/8/9 0009
 * @Description TODO
 */
@Service
public class SayServiceIml {

    @Reference(version = "3.0.0")
    TestService testService;

    public void say(){
        System.out.println("say");
        String res = testService.SayHello();
        System.out.println(res);
    }

}
