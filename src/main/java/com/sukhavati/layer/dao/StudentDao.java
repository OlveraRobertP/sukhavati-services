package com.sukhavati.layer.dao;

import java.util.List;

import com.sukhavati.models.dao.Student;

/**
 * 
 * @author jrobolvp
 *
 */
public interface StudentDao extends PersistenceDao <Student>{

	/**
	 * 
	 * @return
	 */
	List<Student> findAllOrderByName();

}
