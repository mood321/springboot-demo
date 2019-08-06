package com.mood.springbootmybatis;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 *  多数据源需要排除 springboot 默认自动配置
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
/**
 * TK和原来mybatis MapperScan不能用一个
 */
//原生
//@MapperScan("com.mood.springbootmybatis.mybatisnative.mapper")
//tk
//@MapperScan("com.mood.springbootmybatis.tk.mapper")
@ComponentScan("com.mood.springbootmybatis.dataSource")
@EnableTransactionManagement
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
