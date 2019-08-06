package com.mood.springbootmybatis.dataSource.service.impl;

import com.mood.springbootmybatis.dataSource.annotation.DataSource;
import com.mood.springbootmybatis.dataSource.config.DataSourceContextHolder;
import com.mood.springbootmybatis.dataSource.config.DataSourceType;
import com.mood.springbootmybatis.dataSource.config.DynamicDataSource;
import com.mood.springbootmybatis.dataSource.mapper.UserMapper;
import com.mood.springbootmybatis.dataSource.service.UserService;
import com.mood.springbootmybatis.mybatisnative.model.User;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @DataSource(value = DataSourceType.db1)
    public void save(User user) {
        Optional.ofNullable(user.getId())
                .map(e -> this.userMapper.updateByPrimaryKeySelective(user))
                .orElseGet(() -> this.userMapper.insert(user));
        log.info("=======================编号为:{}的用户被保存啦====================", user.getId());
    }

    //从db2中获取到drive-class、url、username、password信息
    @DataSource(DataSourceType.db2)
    public int addDS(String id, User user ){
        // 通过id 动态 获取到drive-class、url、username、password
       // Map<String, Object> getdb = userMapper.getdb(id);

        // 配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://192.168.0.121:3306/mybatis-demo3?useSSL=FALSE&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        // 添加一个数据源到多数据源中
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();
        Map<Object, Object> dataSourceMap = dynamicDataSource.getDataSourceMap();
        dataSourceMap.put(id, dataSource);
        dynamicDataSource.setTargetDataSources(dataSourceMap);

        // 切换数据源
        DataSourceContextHolder.setDataSource(id);

        // 获取用户信息
       /* Map<String, Object> map = studentMapper.selectStudent(1);
*/
        // 更新id为1的用户信息
        int i =userMapper.insert(user);

        // 使用该数据源后，删除该数据源(如果不在使用)
        DynamicDataSource instance = DynamicDataSource.getInstance();
        Map<Object, Object> map = instance.getDataSourceMap();
        map.remove(id);
        instance.setTargetDataSources(map);

        return i;
    }

}
