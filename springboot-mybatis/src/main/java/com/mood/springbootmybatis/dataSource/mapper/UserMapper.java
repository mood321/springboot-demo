package com.mood.springbootmybatis.dataSource.mapper;

import com.mood.springbootmybatis.dataSource.annotation.DataSource;
import com.mood.springbootmybatis.dataSource.config.DataSourceType;
import com.mood.springbootmybatis.mybatisnative.model.User;
import com.mood.springbootmybatis.mybatisnative.model.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper  {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);


    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}