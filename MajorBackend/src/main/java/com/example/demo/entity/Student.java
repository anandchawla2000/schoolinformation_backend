package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Student
{   @Id
	private int admissionid;
@Column(name="name")
private String fname;
private String dob;
private String email;
private String Password;
private String Classall;
@Column(name="Address")
private String Add;
@Override
public String toString() {
	return "Student [admissionid=" + admissionid + ", fname=" + fname + ", dob=" + dob + ", email=" + email
			+ ", Password=" + Password + ", Classall=" + Classall + ", Add=" + Add + "]";
}
public int getAdmissionid() {
	return admissionid;
}
public void setAdmissionid(int admissionid) {
	this.admissionid = admissionid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
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
