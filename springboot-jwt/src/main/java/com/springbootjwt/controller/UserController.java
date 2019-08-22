package com.springbootjwt.controller;

import cn.hutool.json.JSONObject;
import com.springbootjwt.config.annotation.PassToken;
import com.springbootjwt.config.annotation.Token;
import com.springbootjwt.model.User;
import com.springbootjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
