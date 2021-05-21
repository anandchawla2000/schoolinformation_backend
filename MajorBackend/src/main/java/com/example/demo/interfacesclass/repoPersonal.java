package com.example.demo.interfacesclass;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Personalinfo;

public interface repoPersonal extends JpaRepository<Personalinfo, Integer> {

}
