package com.mood.springbootmybatis;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * TK和原来mybatis MapperScan不能用一个
 */
@SpringBootApplication
//@MapperScan("com.mood.springbootmybatis.mybatisnative.mapper")

@MapperScan("com.mood.springbootmybatis.tk.mapper")
@ComponentScan("com.mood.springbootmybatis.tk")
@EnableTransactionManagement
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
