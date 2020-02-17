package com.sukhavati.models.dto;

import java.io.Serializable;

import com.sukhavati.models.dao.Student;
import com.sukhavati.utils.DateFormat;
import com.sukhavati.utils.TypeFormatDate;

import lombok.Data;

@Data
public class StudentDto implements Serializable{
	
	private Integer id;
	private String name;
	private String lastName;
	private String birthDate;
	private String email;
	private String phoneNumber;
	private String mobileNumber;
	private String address;
	private String gender;
	private String rfc;
	private String zipCode;
	private String colonia;
	private String region;
	private String city;
	private String maritalStatus;
	private String comments;
	private String extraComments;
	private String photo;
	
	public StudentDto(){
		
	}
	
	public StudentDto(Student student){
		if(student != null) {
			id = student.getId();
			name = student.getFirstName();
			lastName = student.getLastName();
			birthDate = DateFormat.toString(student.getBirthDate(),TypeFormatDate.SHORT);
			email = student.getEmail();
			phoneNumber = student.getPhoneNumber();
			mobileNumber = student.getMobileNumber();
			address = student.getAddress();
			gender = student.getGender();
			rfc = student.getRfc();
			zipCode = student.getZipCode();
			colonia = student.getColonia();
			region = student.getRegion();
			city = student.getCity();
			maritalStatus = student.getMaritalStatus();
			comments = student.getComments();
			extraComments = student.getExtraComments();
			photo = student.getPhoto();
		}
		
	}
	
}
