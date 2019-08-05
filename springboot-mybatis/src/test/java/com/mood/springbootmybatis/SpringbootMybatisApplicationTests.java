package com.mood.springbootmybatis;

import com.mood.springbootmybatis.mybatisnative.model.User;
import com.mood.springbootmybatis.mybatisnative.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

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


}
