package com.demo.mood.pojo;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="clazz")
@Data
public class Clazz {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",length = 40)
    private String name;


    @OneToMany(mappedBy = "aClazz",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Users> students;


}
