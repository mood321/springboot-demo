package com.mood.springbootmybatis.mybatisnative.mapper;

import com.mood.springbootmybatis.mybatisnative.model.User;
import com.mood.springbootmybatis.mybatisnative.model.UserExample;
import java.util.List;

import com.mood.springbootmybatis.tk.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends MyMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    //int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}