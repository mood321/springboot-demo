package com.mood.springbootjwt.service.impl;

import cn.hutool.json.JSONObject;
import com.mood.springbootjwt.model.User;
import com.mood.springbootjwt.service.UserService;
import com.mood.springbootjwt.util.JwtUtil;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by mood321
 * @Date 2019/8/7 0007 0:40
 * @Description TODO
 */
@Service("userServiceImpl")
@Order(1)
public class UserServiceImpl implements UserService {

    private static Map<Integer, User> map = new HashMap<>(16);

    static {
        map.put(1,new User(1,"张三","111111"));
        map.put(2,new User(2,"李四","222222"));
        map.put(3,new User(3,"王五","333333"));
        map.put(4,new User(4,"赵六","444444"));
        map.put(5,new User(5,"田七","555555"));
    }

    @Override
    public User findByUserId(Integer  userId) {
        return map.get(userId);
    }

    @Override
    public JSONObject login(String username, String password) {
        JSONObject result = new JSONObject();
        User user =  map.entrySet()
                        .stream()
                        .filter(e -> e.getValue().getUsername().equals(username))
                        .findFirst()
                        .map(e -> e.getValue())
                        .orElse(null);
        if (user != null && password.equals(user.getPassword())){
            result.put("result","SUCCESS");
            result.put("token", JwtUtil.createToken(user));
        }else{
            result.put("result","FAIL");
            result.put("msg", "用户名或密码错误");
        }
        return result;
    }
}
