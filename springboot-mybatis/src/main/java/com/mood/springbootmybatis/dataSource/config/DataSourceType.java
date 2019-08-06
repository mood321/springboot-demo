package com.mood.springbootmybatis.dataSource.config;

/**
 * @Created by mood321
 * @Date 2019/8/6 0006 22:33
 * @Description TODO
 */
public enum DataSourceType {
    // 动态数据源 不能固定值
    /*db1,
    db2*/
    db1("db1"),
    db2("db2");
    private String db;
    DataSourceType(String db) {
        this.db = db;
    }
    public String getDb() {
        return db;
    }
    public void setDb(String db) {
        this.db = db;
    }
}
