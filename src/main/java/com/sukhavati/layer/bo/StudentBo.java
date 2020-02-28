package com.sukhavati.layer.bo;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.sukhavati.models.dao.Student;
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
	Map<Response, StudentDto> saveOrUpdate(StudentDto student, String authString);

	/**
	 * 
	 * @param id
	 * @return
	 */
	StudentDto getById(Integer id);

	
	
}
