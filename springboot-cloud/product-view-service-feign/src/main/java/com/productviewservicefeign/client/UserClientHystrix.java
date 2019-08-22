package com.productviewservicefeign.client;

import com.productviewservicefeign.model.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by mood321
 * @Date 2019/8/12 0012
 * @Description  断路器
 */
@Component
public class UserClientHystrix implements UsersClientFeign{
    @Override
    public List<Users> getAll(){
        List<Users> result = new ArrayList<>();
        result.add(new Users(0,"产品数据微服务不可用",0));
        return result;
    }
}
