package com.demo.mood;

import com.demo.mood.dao.ClassDao;
import com.demo.mood.dao.UserDao;
import com.demo.mood.pojo.Clazz;
import com.demo.mood.pojo.Users;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ClassDao classDao;

    @org.junit.Test
    /**
     *  用内置方法添加一条数据
     */
    public void save(){
       Users user= new Users();
       user.setId(1);
       user.setUsername("test");

       userDao.save(user);
    }
    @org.junit.Test
    /**
     * 通过名称查找    @Query 方法
     */
    public void findByName(){

      Users u= userDao.findByName("test");
      System.out.println(u);
    }
    @org.junit.Test
    /**
     *  一对多
     */
    public void oneToMan(){

        Clazz c= classDao.findByName("1");
        System.out.println(c);
       System.out.println(c.getStudents().size());
    }
}

