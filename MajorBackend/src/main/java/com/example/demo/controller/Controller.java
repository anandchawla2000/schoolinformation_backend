package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Teacher;
import com.example.demo.interfacesclass.Emailsend;
import com.example.demo.interfacesclass.Repo;
@CrossOrigin
@RestController
public class Controller 
{   @Autowired
	Teacher teach;
    
    @Autowired
    Repo rep;
    
    @Autowired
    Emailsend emailsend;
	
    @PostMapping("/addteacher")
	@ResponseBody
     public void add(@RequestBody Teacher teach)
     {   
    	String email = teach.getEmail();
    	String password = teach.getPassword();
    	emailsend.sendMail(email, "SIS Company", password);
		rep.save(teach);
     }
}
