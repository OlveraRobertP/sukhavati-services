package com.sukhavati.models.dto;

import java.io.Serializable;

import com.sukhavati.models.dao.User;

import lombok.Data;

@Data
public class UserDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9180697265364498234L;
	
	private Integer id;
	private String userId;
	private String userName;
	private String emailId;
	
	public UserDto() {
	}
	
	public UserDto(User user) {
		if(user!=null) {
			this.id = user.getId();
			this.userId = user.getUserId();
			this.userName = user.getUserName();
		}		
	}

}
