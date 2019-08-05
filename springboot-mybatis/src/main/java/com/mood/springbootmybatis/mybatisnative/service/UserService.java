package com.mood.springbootmybatis.mybatisnative.service;


import com.mood.springbootmybatis.mybatisnative.model.User;

public interface UserService {



    void save(User user);


    void deleteById(Integer id);
    public int saveUserByTk(User user);
}
