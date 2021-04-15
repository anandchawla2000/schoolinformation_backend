package com.example.demo.interfacesclass;

import javax.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Teacher;

public interface Repo extends CrudRepository<Teacher, Integer>
{
   
}
