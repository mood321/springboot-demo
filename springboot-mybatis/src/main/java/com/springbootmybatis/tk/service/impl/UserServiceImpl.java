package com.springbootmybatis.tk.service.impl;

import com.springbootmybatis.mybatisnative.model.User;
import com.springbootmybatis.tk.mapper.UserMapper;
import com.springbootmybatis.tk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserServiceTkImpl")
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void save(User user) {
        userMapper.insert(user);
        log.info("=======================编号为:{}的用户被保存啦====================", user.getId());
    }


}
