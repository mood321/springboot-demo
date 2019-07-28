package com.demo.mood.dao;

import com.demo.mood.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Users,Long> {

    //@Query("select u from Users u where u.username = ?1")
    @Query("select u from Users u where u.username = :name")
    Users findByName(@Param("name") String name);
}
