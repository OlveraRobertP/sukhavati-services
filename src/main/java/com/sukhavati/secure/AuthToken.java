package com.sukhavati.secure;

import com.sukhavati.layer.dao.UserDao;
import com.sukhavati.models.dao.User;
import com.sukhavati.persistence.hibernate.UserDaoImpl;

/**
 * 
 * @author jrobolvp
 *
 */
public class AuthToken {
	
	private static UserDao userDao = new UserDaoImpl();

	public static User getUserByAuth(String authString) {
		userDao.openSession();
		User result = userDao.findBy("id",Integer.valueOf(authString) );
		userDao.closeSession();
		return result;
	}

}
