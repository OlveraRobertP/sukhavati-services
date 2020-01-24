package com.sukhavati.layer.dao;

import com.sukhavati.models.dao.User;

/**
 * 
 * @author jrobolvp
 *
 */
public interface UserDao extends PersistenceDao <User>{

	/**
	 * Devuelve usuario por userId y password
	 * @param userId
	 * @param password
	 * @return
	 */
	User getUserByUserIdAndPassword(String userId, String password);

}
