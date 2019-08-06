package com.mood.springbootmybatis;

import com.mood.springbootmybatis.dataSource.service.impl.UserServiceImpl;
import com.mood.springbootmybatis.mybatisnative.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDSMybatisApplicationTests {

    @Autowired
    UserServiceImpl userService;
    @Test
    public void userSave() {
        User user = new User();
        user.setId(1);
        user.setAge(12);
        user.setName("test");
        userService.save(user);
    }
    @Test
    public void test() {
        User user = new User();
        user.setId(1);
        user.setAge(12);
        user.setName("test");
        userService.addDS("4",user);
    }


}
