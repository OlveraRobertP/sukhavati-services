package com.sukhavati.bo.impl;

import java.util.List;

import com.sukhavati.bo.PersonBo;
import com.sukhavati.dao.PersonDao;
import com.sukhavati.models.Person;
import com.sukhavati.persistence.hibernate.PersonDaoImpl;

public class PersonBoImpl implements PersonBo {

	
	private PersonDao personDao = new PersonDaoImpl();
	
	@Override
	public List<Person> findAll() {
		List<Person> result = null;
		personDao.openSession();
		result = personDao.findAll();
		personDao.closeSession();
		return result;
	}

}
