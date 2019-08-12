package com.mood.productviewserviceribbon.client;

import com.mood.productviewserviceribbon.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Created by mood321
 * @Date 2019/8/12 0012
 * @Description Ribbon 客户端， 通过 restTemplate 访问 http://PRODUCT-DATA-SERVICE/getAll ，
 * 而 product-data-service 既不是域名也不是ip地址，而是 数据服务在 eureka 注册中心的名称
 *
 * 注意看，这里只是指定了要访问的 微服务名称
 */
@Component
public class UserClientRibbon {
    @Autowired
    RestTemplate restTemplate;

    public List<Users> getAll() {
        return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/getAll",List.class);
    }
}
