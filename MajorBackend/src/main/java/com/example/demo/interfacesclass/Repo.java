package com.example.demo.interfacesclass;

import com.example.demo.entity.Teacher;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface Repo extends JpaRepository<Teacher, Integer>
{  
    @Query("from Teacher where email= :email And password= :password")
	List<Teacher> find(@Param("email") String email,@Param("password") String pasword);
 
}