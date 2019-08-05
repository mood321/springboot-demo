package com.mood.springbootmybatis.mybatisnative.service.impl;

import com.mood.springbootmybatis.mybatisnative.mapper.UserMapper;
import com.mood.springbootmybatis.mybatisnative.model.User;
import com.mood.springbootmybatis.mybatisnative.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void save(User user) {
        Optional.ofNullable(user.getId())
                .map(e -> this.userMapper.updateByPrimaryKeySelective(user))
                .orElseGet(() -> this.userMapper.insertSelective(user));
        log.info("=======================编号为:{}的用户被保存啦====================", user.getId());
    }


    @Override
    public void deleteById(Integer id) {
        this.userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int saveUserByTk(User user) {
        return this.userMapper.insert(user);
    }
}
