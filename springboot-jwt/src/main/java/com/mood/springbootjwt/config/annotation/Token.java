package com.mood.springbootjwt.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Created by mood321
 * @Date 2019/8/7 0007 0:37
 * @Description TODO
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
    boolean required() default true;
}
