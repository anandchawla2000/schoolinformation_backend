package com.example.demo.interfacesclass;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AcademicInfo;

public interface repoAcademic extends JpaRepository<AcademicInfo, Integer> {

}
