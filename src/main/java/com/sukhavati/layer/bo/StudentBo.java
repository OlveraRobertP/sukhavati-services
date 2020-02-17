package com.sukhavati.layer.bo;

import java.util.List;

import javax.xml.ws.Response;

import com.sukhavati.models.dto.StudentDto;

public interface StudentBo {
	
	/**
	 * 
	 * @return
	 */
	List<StudentDto> getAll();
	
	/**
	 * 
	 * @param student
	 * @return
	 */
	javax.ws.rs.core.Response saveOrUpdate(StudentDto student);
	
}
