package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Personalinfo {
	@Id
	private int id;
	private String fatherName;
	private String motherName;
	private String aadharCard;
	private int pinCode;
	private String district;
	private String parentsPhone;
	private String bloodGroup;
	private String hobbies;
	@Override
	public String toString() {
		return "Personalinfo [id=" + id + ", fatherName=" + fatherName + ", motherName=" + motherName + ", aadharCard="
				+ aadharCard + ", pinCode=" + pinCode + ", district=" + district + ", parentsPhone=" + parentsPhone
				+ ", bloodGroup=" + bloodGroup + ", hobbies=" + hobbies + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getParentsPhone() {
		return parentsPhone;
	}
	public void setParentsPhone(String parentsPhone) {
		this.parentsPhone = parentsPhone;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
}
