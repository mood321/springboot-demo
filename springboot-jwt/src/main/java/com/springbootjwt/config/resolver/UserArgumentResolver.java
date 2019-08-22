package com.springbootjwt.config.resolver;

import com.springbootjwt.config.annotation.Token;
import com.springbootjwt.model.User;
import com.springbootjwt.service.UserService;
import com.springbootjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * @Created by mood321
 * @Date 2019/8/7
 * @Description TODO
 */

public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired

    UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(User.class) && methodParameter.hasParameterAnnotation(Token.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = nativeWebRequest.getHeader("token");
        if (token != null){
            Integer userId = JwtUtil.getUserId(token);
            if (userId != null){
                User user = this.userService.findByUserId(userId);
                if (user != null){
                    return user;
                }
            }
        }
        return null;
    }
}
