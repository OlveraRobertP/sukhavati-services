package com.sukhavati.persistence.hibernate;

import com.sukhavati.layer.dao.UserDao;
import com.sukhavati.models.dao.User;

public class UserDaoImpl extends PersistenceDaoImpl<User> implements UserDao {

	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		return (User) super.getSession().createQuery("From User u where u.userId = :userId and u.password = :password")
				.setParameter("userId", userId)
				.setParameter("password", password)
				.uniqueResult();
	}

}
