package com.sukhavati.models.dto;

import java.io.Serializable;

import com.sukhavati.models.dao.User;

import lombok.Data;

@Data
public class UserDto implements Serializable{

	private Integer id;
	private String userid;
	private String userName;
	private String emailId;
	
	public UserDto() {
	}
	
	public UserDto(User user) {
		if(user!=null) {
			this.id = user.getId();
			this.userid = user.getUserId();
			this.userName = user.getUserName();
			this.emailId = user.getEmail();
		}		
	}

}
