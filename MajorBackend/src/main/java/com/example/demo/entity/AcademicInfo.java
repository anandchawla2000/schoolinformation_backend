package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class AcademicInfo {
	@Id
	private int id;
	private float classXII;
	private float classX;
	private String extraAcademicinfo;
	private String certificate;
	@Override
	public String toString() {
		return "AcademicInfo [id=" + id + ", classXII=" + classXII + ", classX=" + classX + ", extraAcademicinfo="
				+ extraAcademicinfo + ", certificate=" + certificate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getClassXII() {
		return classXII;
	}
	public void setClassXII(float classXII) {
		this.classXII = classXII;
	}
	public float getClassX() {
		return classX;
	}
	public void setClassX(float classX) {
		this.classX = classX;
	}
	public String getExtraAcademicinfo() {
		return extraAcademicinfo;
	}
	public void setExtraAcademicinfo(String extraAcademicinfo) {
		this.extraAcademicinfo = extraAcademicinfo;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
}
