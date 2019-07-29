package com.demo.mood.springboot.Condition;

import com.demo.mood.springboot.pojo.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @Description 自定义bean注册  config演示类
 * @Created by mood321
 */
@Configurable
public class ConditionConfig {

    /**
     *  会根据MyCondition matches返回值判断是否注册
     * @return
     */
    @Conditional(MyCondition.class)
    @Bean
    public Person person(){
        return new Person();
    }
    /**
     * @ConditionalOnBean
     * 容器中存在指定 Bean，则生效。
     * @return
     */
    @Bean
    @ConditionalOnBean(Person.class)
    public Person dogBean(){
        return new Person();
    }

    /**
     * @ConditionalOnBean
     * 容器中不存在指定 Bean，则生效。
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(Person.class)
    public Person birdBean(){
        return new Person();
    }
}
