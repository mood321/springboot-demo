package com.mood.springbootmybatis.dataSource.aop;

import com.mood.springbootmybatis.dataSource.annotation.DataSource;
import com.mood.springbootmybatis.dataSource.config.DataSourceContextHolder;
import com.mood.springbootmybatis.dataSource.config.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Created by mood321
 * @Date 2019/8/6 0006 23:06
 * @Description TODO
 */
@Slf4j
@Aspect
@Component
public class DataSourceAspect {
    @Before("@annotation(ds)")
    public void beforeDataSource(DataSource ds) {

        String value = ds.value().getDb();
        DataSourceContextHolder.setDataSource(value);
        log.info("当前使用的数据源为：{}", value);
    }
    @After("@annotation(ds)")
    public void afterDataSource(DataSource ds){
        DataSourceContextHolder.clearDataSource();
    }
}
