package com.mood.springbootjwt.service;

import cn.hutool.json.JSONObject;
import com.mood.springbootjwt.model.User;
import org.springframework.stereotype.Service;

/**
 * @Created by mood321
 * @Date 2019/8/7 0007 0:40
 * @Description TODO
 */

public interface UserService {

    JSONObject login(String username, String password);

    User findByUserId(Integer userId);
}
