package com.sukhavati.layer.bo;

import java.util.List;

import com.sukhavati.models.dao.Menu;
import com.sukhavati.models.dto.MenuDto;
import com.sukhavati.models.dto.UserDto;

public interface SecurityBo {
	/**
	 * Devuelve el usuario que coincida con el userId y el password
	 * @param userId
	 * @param password
	 * @return
	 */
	UserDto getUserByUserIdAndPassword(String userId, String password);
	
	/**
	 * Devuelve los menus a los que tiene acceso el usuario
	 * @param userId
	 * @return
	 */
	List<MenuDto> getMenusByUser(String userId);
	
	/**
	 * Devuelve los menus a los que tiene acceso el usuario
	 * @param userId
	 * @return
	 */
	MenuDto[] getMenusByUser2(String userId);
}
