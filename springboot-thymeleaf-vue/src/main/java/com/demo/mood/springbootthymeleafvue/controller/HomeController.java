package com.demo.mood.springbootthymeleafvue.controller;


import com.demo.mood.springbootthymeleafvue.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@Slf4j
public class HomeController {


    @GetMapping("/")
    public String index() {
        return "main";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(String userName) {
        return userName;
    }

    @GetMapping("/listAllUser")
    @ResponseBody
    public List<User> listAllUser() {
        log.info("进入/listAllUser");
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setImage("baidu.com");
            user.setTitle("Test");
            user.setUrl("baidu.com");
            list.add(user);
        }
        return list;
    }




}
