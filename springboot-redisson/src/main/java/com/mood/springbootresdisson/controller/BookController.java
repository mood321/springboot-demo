package com.mood.springbootresdisson.controller;

import cn.hutool.http.HttpUtil;
import com.mood.springbootresdisson.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by mood321
 * @Date 2019/8/19 0019
 * @Description TODO
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public String book(){
        return this.bookService.book();
    }

    @GetMapping("/bookWithLock")
    public String bookWithLock(){
        return this.bookService.bookWithLock();
    }

}
