package com.example.demo.interfacesclass;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;

public interface Repostudent extends JpaRepository<Student, Integer> 
{
	 @Query("from Student where email= :email And password= :password")
		List<Student> find(@Param("email") String email,@Param("password") String pasword);
}
