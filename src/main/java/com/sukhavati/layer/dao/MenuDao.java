package com.sukhavati.layer.dao;

import java.util.List;

import com.sukhavati.models.dao.Menu;

/**
 * 
 * @author jrobolvp
 *
 */
public interface MenuDao extends PersistenceDao <Menu>{
	
	/**
	 * Devuelve los menus a los que tiene acceso el usuario
	 * @param userId
	 * @return
	 */
	List<Menu> getMenusByUser(String userId);

}
