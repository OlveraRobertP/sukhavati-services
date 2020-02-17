/**
 * 
 */
package com.sukhavati.persistence.hibernate;

import java.util.List;

import org.hibernate.criterion.Order;

import com.sukhavati.layer.dao.StudentDao;
import com.sukhavati.models.dao.Student;

/**
 * @author jrobolvp
 *
 */
public class StudentDaoImpl  
	extends PersistenceDaoImpl<Student> 
	implements StudentDao {
	
	
	@Override
	public List<Student> findAll() {
		return super.getSession()
				.createCriteria(Student.class)
				.addOrder(Order.asc("id"))
				.list();
	}
}
