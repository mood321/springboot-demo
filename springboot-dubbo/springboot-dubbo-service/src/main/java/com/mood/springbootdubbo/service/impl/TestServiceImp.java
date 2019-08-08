package com.mood.springbootdubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.mood.springbootdubbo.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @Created by mood321
 * @Date 2019/8/9 0009
 * @Description TODO
 */
@Service(version = "3.0.0")
@Component
public class TestServiceImp implements TestService {
    @Override
    public String SayHello() {
        System.out.println("Here is serivce");
        return "hello ";
    }
}
