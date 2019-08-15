package com.mood.springbootrabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Created by mood321
 * @Date 2019/8/14 0014
 * @Description TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users implements Serializable {


    private Integer id;

    private String name;

    private Integer age;

    public Users(String name){
        this.name=name;
    }
}
