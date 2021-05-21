package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
public class Student {
	@Id
	private int admissionid;
	@Column(name = "name")
	private String fname;
	private String dob;
	private String email;
	private String password;
	@Column(name = "Classall")
	private String classall;
	@Column(name = "Address")
	private String Add;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Personalinfo personalinfo;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private AcademicInfo academicinfo;
	private boolean statuspers;
	private boolean statusacad;

	@Override
	public String toString() {
		return "Student [admissionid=" + admissionid + ", fname=" + fname + ", dob=" + dob + ", email=" + email
				+ ", password=" + password + ", classall=" + classall + ", Add=" + Add + ", personalinfo="
				+ personalinfo + ", academicinfo=" + academicinfo + ", statuspers=" + statuspers + ", statusacad="
				+ statusacad + "]";
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
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClassall() {
		return classall;
	}

	public void setClassall(String classall) {
		this.classall = classall;
	}

	public String getAdd() {
		return Add;
	}

	public void setAdd(String add) {
		Add = add;
	}

	public Personalinfo getPersonalinfo() {
		return personalinfo;
	}

	public void setPersonalinfo(Personalinfo personalinfo) {
		this.personalinfo = personalinfo;
	}

	public AcademicInfo getAcademicinfo() {
		return academicinfo;
	}

	public void setAcademicinfo(AcademicInfo academicinfo) {
		this.academicinfo = academicinfo;
	}

	public boolean isStatuspers() {
		return statuspers;
	}

	public void setStatuspers(boolean statuspers) {
		this.statuspers = statuspers;
	}

	public boolean isStatusacad() {
		return statusacad;
	}

	public void setStatusacad(boolean statusacad) {
		this.statusacad = statusacad;
	}

}
