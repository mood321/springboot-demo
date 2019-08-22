package com.productdataservice.controller;

import com.productdataservice.service.UserServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Created by mood321
 * @Date 2019/8/11 0011
 * @Description TODO
 */
@Controller
public class UserController {
    @Autowired
    UserServce userServce;

    @RequestMapping("getAll")
    @ResponseBody
    public List getAll(){
        return userServce.getAll();
    }
}
