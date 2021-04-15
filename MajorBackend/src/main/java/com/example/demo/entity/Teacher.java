package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Teacher 
{  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
  @Column(name="name")
   private String fname;
   private String email;
   private String Password;
   private String Classall;
   @Column(name="Address")
   private String Add;
@Override
public String toString() {
	return "Teacher [id=" + id + ", fname=" + fname + ", email=" + email + ", Password=" + Password + ", Classall="
			+ Classall + ", Add=" + Add + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getClassall() {
	return Classall;
}
public void setClassall(String classall) {
	Classall = classall;
}
public String getAdd() {
	return Add;
}
public void setAdd(String add) {
	Add = add;
}

   
}
