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
import com.example.demo.interfacesclass.repoAcademic;
import com.example.demo.interfacesclass.repoPersonal;
import com.fasterxml.jackson.databind.util.JSONPObject;
import java.util.*;
import netscape.javascript.JSObject;

import com.example.demo.entity.AcademicInfo;
import com.example.demo.entity.Personalinfo;
import com.example.demo.entity.Student;

//Servlet control all request and resposnse
@CrossOrigin
@RestController
public class Controller { // create object
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
	@Autowired
	AcademicInfo acdemicinfo;
	@Autowired
	Personalinfo personalinfo;
	@Autowired
	repoAcademic repoacademic;
	@Autowired
	repoPersonal repopersonal;

	// Add new teacher
	@PostMapping("/addteacher")
	public void add(@RequestBody Teacher teach) {
		String email = teach.getEmail();
		String password = teach.getPassword();
		String msg = "Your login credit details email id" + email + "password " + password + "";
		emailsend.sendMail(email, "SIS Company", msg);
		rep.save(teach);
	}

	// Add New Student
	@PostMapping("/addstudent")
	public void add(@RequestBody Student Student) {
		int id = (int) repostudent.count();
		Student.setAdmissionid((id + 1));
		acdemicinfo.setId((id + 1));
		personalinfo.setId((id + 1));
		Student.setAcademicinfo(acdemicinfo);
		Student.setPersonalinfo(personalinfo);
		Student.setStatusacad(false);
		Student.setStatuspers(false);
		String email = Student.getEmail();
		String password = Student.getPassword();
		System.out.println(Student);
		String msg = "Your login credit details email id =" + email + " And password = " + password + "";
		emailsend.sendMail(email, "SIS Company", msg);
		repostudent.save(Student);

	}

	// For Login
	@GetMapping("/sign/")
	public String sign(@RequestParam("email") String email, @RequestParam("password") String password) {
		JSONObject json = new JSONObject();
		List list = rep.find(email, password);
		ArrayList<Student> list1 = repostudent.find(email, password);
		System.out.println(list);
		System.out.println(list1);
		if (list.isEmpty()) {
			if (list1.isEmpty()) {
				json.put("type", "khali");
			} else {
				int data = list1.get(0).getAdmissionid();
				json.put("data", data);
				json.put("type", "Student");
			}
		} else {
			json.put("data", list);
			json.put("type", "teacher");
		}

		return json.toString();
	}

	// For Teacher Page
	@GetMapping("/details/{id}")
	public List<Student> Studentdetails(@PathVariable("id") String id) {
		System.out.println(repostudent.findByclassall(id));
		return (repostudent.findcheck(id, 0, 0));
	}

	@PostMapping("/peronalinfo")
	public void peronalinfo(@RequestBody Personalinfo personalinfo) {
		System.out.print(personalinfo);
		int id = personalinfo.getId();
		repostudent.updatepsinfo(id);
		repopersonal.save(personalinfo);
	}

	@PostMapping("/academicinfo")
	public void academicinfo(@RequestBody AcademicInfo acddemicinfo) {
		int id = acddemicinfo.getId();
		repostudent.updateacinfo(id);
		repoacademic.save(acddemicinfo);
	}

	// for test controller
	@GetMapping("/test")
	public void check() {

	}
   //For Student Information
	@GetMapping("/info/{id}")
	public Student studentinfo(@PathVariable("id") Integer id) {
		return (repostudent.findById(id).orElse(null));
	}
	//For Teacher Information
	@GetMapping("/teacher/{id}")
	public Teacher teaherinfo(@PathVariable("id") Integer id) {
		return (rep.findById(id).orElse(null));
	}
	
	//Student List
	@GetMapping("/List")
	public List<Student> studentList() {
		return (repostudent.findAll());
	}
	
	//Teacher list
	@GetMapping("/Listteacher")
	public List<Teacher> Teacherlist(){
		return(rep.findAll());
	}
	
	//Student by class
	@GetMapping("/Student/{id}")
	public List<Student> Studentbyclassid(@PathVariable("id") String id){
		return(repostudent.findByclassall(id));
	}
}
