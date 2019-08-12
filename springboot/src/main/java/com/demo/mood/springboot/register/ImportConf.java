package com.demo.mood.springboot.register;

import com.demo.mood.springboot.pojo.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

/**
 * @Date 2019/7/29 0029 21:59
 * @Created by mood31
 * @Description  用Import 注册bean
 */

/**
 * 给容器中注册组件的方式
 * 1,@Bean: [导入第三方的类或包的组件],比如Person为第三方的类, 需要在我们的IOC容器中使用
 * 2,包扫描+组件的标注注解(@ComponentScan:  @Controller, @service  @Reponsitory  @ Componet),一般是针对 我们自己写的类,使用这个
 * 3,@Import:[快速给容器导入一个组件] 注意:@Bean有点简单
 *      a,@Import(要导入到容器中的组件):容器会自动注册这个组件,bean 的 id为全类名
 *      b,ImportSelector:是一个接口,返回需要导入到容器的组件的全类名数组
 *      c,ImportBeanDefinitionRegistrar:可以手动添加组件到IOC容器, 所有Bean的注册可以使用BeanDifinitionRegistry
 *          写ImportBeanDefinitionRegistrar实现ImportBeanDefinitionRegistrar接口即可
 *  4,使用Spring提供的FactoryBean(工厂bean)进行注册
 */
@Configurable
@Import(Person.class)
public class ImportConf {

    /**
     *  有两个的时候 优先选择Primary 注入
     * @return
     */
    @Primary
    @Bean
    public Person person(){
        return new Person();
    }
}
