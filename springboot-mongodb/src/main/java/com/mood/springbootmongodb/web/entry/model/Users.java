package com.mood.springbootmongodb.web.entry.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Created by mood321
 * @Date 2019/8/22 0022
 * @Description TODO
 */
@Data
public class Users {
    private Integer id;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    private Integer age;
}
