package com.mood.springbootdubboclient;

import com.mood.springbootdubboclient.serivce.iml.SayServiceIml;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDubboClientApplicationTests {

    @Autowired
    SayServiceIml sayServiceIml;
    @Test
    public void contextLoads() {
        sayServiceIml.say();
    }

}
