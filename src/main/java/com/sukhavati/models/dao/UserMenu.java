package com.sukhavati.models.dao;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserMenu implements Serializable{

	private User user;
	private Menu menu;
	
}
