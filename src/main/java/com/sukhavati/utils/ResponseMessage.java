package com.sukhavati.utils;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseMessage implements Serializable {
	private String code;
	private String message;
	
	public ResponseMessage() {
		
	}
	
	public ResponseMessage(String code) {
		this.code = code;
	}
}
