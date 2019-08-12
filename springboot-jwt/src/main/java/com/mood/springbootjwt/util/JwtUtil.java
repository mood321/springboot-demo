package com.mood.springbootjwt.util;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.mood.springbootjwt.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Optional;

/**
 * @Created by mood321
 * @Date 2019/8/7 0007 0:26
 * @Description TODO
 */
@Slf4j
public class JwtUtil {

    public static String createToken(User user){
        Date now = new Date();
        return JWT.create()
                //设置载荷payload
                .withClaim("userId",user.getId())
                //生成签名的时间
                .withIssuedAt(now)
                //签名过期的时间
                .withExpiresAt(DateUtil.offsetHour(now,1).toJdkDate())
                .sign(Algorithm.HMAC256(user.getPassword()));
    }

    public static boolean verifyToken(String token,String secret){
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(secret)){
            return false;
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        try {
            jwtVerifier.verify(token);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return false;
        }
    }

    public static Integer getUserId(String token){
        try {
            return Optional.ofNullable(JWT.decode(token).getClaim("userId")).map(e -> e.asInt()).orElse(null);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return null;
        }
    }
}