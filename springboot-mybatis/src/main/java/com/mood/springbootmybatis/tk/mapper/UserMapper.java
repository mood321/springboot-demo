package com.mood.springbootmybatis.tk.mapper;

import com.mood.springbootmybatis.mybatisnative.model.User;
import com.mood.springbootmybatis.mybatisnative.model.UserExample;
import com.mood.springbootmybatis.tk.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

}