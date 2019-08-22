package com.mood.springbootmongodb.web.controller;

import cn.hutool.core.util.RandomUtil;
import com.mood.springbootmongodb.aop.annotation.AppLog;
import com.mood.springbootmongodb.web.entry.dto.Result;
import com.mood.springbootmongodb.web.entry.model.AppVisitLog;
import com.mood.springbootmongodb.web.entry.model.Users;
import com.mood.springbootmongodb.web.service.AppVisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Created by mood321
 * @Date 2019/8/22 0022
 * @Description TODO
 */
@RestController
public class TestController {


    @Autowired
    private AppVisitLogService appVisitLogService;

    @GetMapping("/hello")
    public Result hello(@NotBlank(message = "姓名不能为空") String name){
        return Result.genSuccessResult("Hello World " + name);
    }

    @PostMapping("save")
   // @AppLog
    public Result save(@Valid Users user, BindingResult br) throws BindException {
        if (br.hasErrors()){
            throw new BindException(br);
        }
        user.setId(RandomUtil.randomInt(100));

        return Result.genSuccessResult(user);
    }
    @GetMapping("get")

    public Result get(String id) throws BindException {

        AppVisitLog byUuidAndCreateTime = appVisitLogService.findByUuidAndCreateTime(id, new Date());
        return Result.genSuccessResult(byUuidAndCreateTime);
    }
}
