package com.mood.productviewserviceribbon.service;

import com.mood.productviewserviceribbon.client.UserClientRibbon;
import com.mood.productviewserviceribbon.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by mood321
 * @Date 2019/8/12 0012
 * @Description TODO
 */
@Service
public class Userservice {
    @Autowired
    UserClientRibbon userClientRibbon;

    public List<Users> getAll(){
        List<Users> all = userClientRibbon.getAll();
        return  all;
    }
}
