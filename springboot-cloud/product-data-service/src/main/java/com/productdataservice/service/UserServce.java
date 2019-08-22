package com.productdataservice.service;

import com.productdataservice.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by mood321
 * @Date 2019/8/11 0011
 * @Description TODO
 */
@Service

public class UserServce {
    @Value("${server.port}")
    Integer port;

    public List<Users> getAll(){
        ArrayList<Users> list = new ArrayList<>();
        list.add(new Users(1,"zs"+port,11));
        list.add(new Users(2,"ls"+port,22));
        list.add(new Users(3,"ww"+port,33));

        return list;
    }
}
