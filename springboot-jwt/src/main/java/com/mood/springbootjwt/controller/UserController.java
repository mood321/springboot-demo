package com.mood.springbootjwt.controller;

import cn.hutool.json.JSONObject;
import com.mood.springbootjwt.config.annotation.PassToken;
import com.mood.springbootjwt.config.annotation.Token;
import com.mood.springbootjwt.model.User;
import com.mood.springbootjwt.service.UserService;
import com.mood.springbootjwt.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotBlank;

/**
 * @Created by mood321
 * @Date 2019/8/7
 * @Description TODO
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @PassToken
    @ResponseBody
    public JSONObject login( String username, String password){
        return this.userService.login(username,password);
    }

    @Token
    @PostMapping("checkUserInfo")
    @ResponseBody
    public User save(User user){
        return user;
    }
}
