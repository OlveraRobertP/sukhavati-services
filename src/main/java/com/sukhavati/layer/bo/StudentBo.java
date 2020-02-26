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
	 * @param authString
	 * @return
	 */
	javax.ws.rs.core.Response saveOrUpdate(StudentDto student, String authString);

	/**
	 * 
	 * @param id
	 * @return
	 */
	StudentDto getById(Integer id);

	
	
}
