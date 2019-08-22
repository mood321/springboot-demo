package com.springbootmybatis.mybatisnative.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Created by mood321
 * @Date 2019/8/5 0005 23:56
 * @Description TODO
 */
//@Configurable
public class DataSourceConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUser;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;



    @Bean
    @Primary
    public DataSource dataSource() throws PropertyVetoException {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        // 关闭连接后不自动提交
        dataSource.setAutoCommit(false);

        return dataSource;
    }


}
