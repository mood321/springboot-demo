package com.mood.springbootmybatis.dataSource.annotation;

import com.mood.springbootmybatis.dataSource.config.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Created by mood321
 * @Date 2019/8/6 0006 23:04
 * @Description 自定义注解，用于类或方法上，优先级：方法>类
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    DataSourceType value() default DataSourceType.db1;
}