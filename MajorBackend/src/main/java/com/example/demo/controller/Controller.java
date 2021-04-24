package com.example.demo.controller;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Teacher;
import com.example.demo.interfacesclass.Emailsend;
import com.example.demo.interfacesclass.Repo;
import com.example.demo.interfacesclass.Repostudent;
import com.fasterxml.jackson.databind.util.JSONPObject;
import java.util.*;
import netscape.javascript.JSObject;
import com.example.demo.entity.Student;

@CrossOrigin
@RestController
public class Controller 
{
	@Autowired
	Teacher teach;
	@Autowired
	Student Student;
	@Autowired
	Repo rep;
	@Autowired
	Repostudent repostudent;
	@Autowired
	Emailsend emailsend;

	@PostMapping("/addteacher")
	public void add(@RequestBody Teacher teach) {
		String email = teach.getEmail();
		String password = teach.getPassword();
		String msg = "Your login credit details email id" + email + "password " + password + "";
		emailsend.sendMail(email, "SIS Company", msg);
		rep.save(teach);
	}

	@PostMapping("/addstudent")
	public void add(@RequestBody Student Student) {
		String email = Student.getEmail();
		String password = Student.getPassword();
		System.out.println(Student);
		String msg = "Your login credit details email id =" + email + " And password = " + password + "";
		emailsend.sendMail(email, "SIS Company", msg);
		repostudent.save(Student);
	}

	@GetMapping("/sign/")
	public String sign(@RequestParam("email") String email, @RequestParam("password") String password) 
	{   JSONObject json = new JSONObject();
		List list = rep.find(email,password);
		List list1 = repostudent.find(email,password);
		if(list.isEmpty())
		{
		  if(list1.isEmpty())
			{
				json.put("type", "khali");
			}
			else
			{
				json.put("data", list1);
				json.put("type", "Student");
			}
		}
		else
		{   
			json.put("data", list);
			json.put("type", "teacher");}
		
		return json.toString();
	}

    
}
