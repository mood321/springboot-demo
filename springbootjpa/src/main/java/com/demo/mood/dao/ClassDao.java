package com.demo.mood.dao;

import com.demo.mood.pojo.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDao extends JpaRepository<Clazz,Long> {

    //@Query("select u from Users u where u.username = ?1")
    @Query("select c from com.demo.mood.pojo.Clazz c where c.name = :name")
    Clazz findByName(@Param("name") String name);
}
