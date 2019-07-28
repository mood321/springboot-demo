package com.demo.mood.pojo;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
public class Users {
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column(length = 50)
    private String username;



    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="clazz_id",referencedColumnName = "id")
    private Clazz aClazz;
}