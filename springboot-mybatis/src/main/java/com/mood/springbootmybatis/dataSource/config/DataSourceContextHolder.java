package com.mood.springbootmybatis.dataSource.config;

/**
 * @Created by mood321
 * @Date 2019/8/6 0006 22:45
 * @Description 动态数据源上下文管理：设置数据源，获取数据源，清除数据源
 */
public class DataSourceContextHolder {
    // 存放当前线程使用的数据源类型
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // 设置数据源
    public static void setDataSource(String type){
        contextHolder.set(type);
    }

    // 获取数据源
    public static String getDataSource(){
        return contextHolder.get();
    }

    // 清除数据源
    public static void clearDataSource(){
        contextHolder.remove();
    }
}
