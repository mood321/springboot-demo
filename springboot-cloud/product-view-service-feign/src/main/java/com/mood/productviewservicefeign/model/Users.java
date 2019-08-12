package com.mood.productviewservicefeign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Created by mood321
 * @Date 2019/8/11 0011
 * @Description TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
     private Integer id;
     private  String name;
     private Integer age;
}
