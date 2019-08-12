package com.mood.productviewserviceribbon.controller;

import com.mood.productviewserviceribbon.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Created by mood321
 * @Date 2019/8/12 0012
 * @Description TODO
 */
@Controller
public class UserController {
    @Autowired
    Userservice userservice;

    @RequestMapping("/getAll")
    public String getAll(ModelMap model) {
        model.addAttribute("list", userservice.getAll());
        return "users.html";
    }
}
