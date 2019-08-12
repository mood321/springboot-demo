package com.mood.productviewservicefeign.service;

import com.mood.productviewservicefeign.client.UsersClientFeign;
import com.mood.productviewservicefeign.model.Users;
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
    UsersClientFeign usersClientFeign;

    public List<Users> getAll(){
        List<Users> all = usersClientFeign.getAll();
        return  all;
    }
}
