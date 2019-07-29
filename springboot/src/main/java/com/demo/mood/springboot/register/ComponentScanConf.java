package com.demo.mood.springboot.register;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Description register 扫描自定义
 * @Date 2019/7/29 0029 21:49
 * @Created by mood321
 *  @Filter: 扫描规则
 *  @ComponentScan(value="",includeFilters={ @Filter(type=FilterType.ANNOTATION,classes={Controller.class}), @Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class})
 * },useDefaultFilters=false) //默认是true,扫描所有组件，要改成false,使用自定义扫描范围
 * @ComponentScan value:指定要扫描的包
 * excludeFilters = Filter[] 指定扫描的时候按照什么规则排除那些组件
 * includeFilters = Filter[] 指定扫描的时候只需要包含哪些组件
 * useDefaultFilters = false 默认是true,扫描所有组件，要改成false
 * －－－－扫描规则如下
 * FilterType.ANNOTATION：按照注解
 * FilterType.ASSIGNABLE_TYPE：按照给定的类型；比如按BookService类型
 * FilterType.ASPECTJ：使用ASPECTJ表达式
 * FilterType.REGEX：使用正则指定
 * FilterType.CUSTOM：使用自定义规则，自已写类，实现TypeFilter接口
 * FilterType.CUSTOM的例子,常用
 *先新增自定义过滤规则类:自定义FilterType的子类 重写match方法
 */
@Configurable
@ComponentScan(value="", includeFilters={
        @ComponentScan.Filter(type= FilterType.ANNOTATION, classes={Controller.class})
}, useDefaultFilters=false)

public class ComponentScanConf {
}
