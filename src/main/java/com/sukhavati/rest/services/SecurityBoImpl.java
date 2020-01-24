package com.sukhavati.rest.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sukhavati.layer.bo.SecurityBo;
import com.sukhavati.layer.dao.MenuDao;
import com.sukhavati.layer.dao.UserDao;
import com.sukhavati.models.dao.Menu;
import com.sukhavati.models.dto.MenuDto;
import com.sukhavati.models.dto.UserDto;
import com.sukhavati.persistence.hibernate.MenuDaoImpl;
import com.sukhavati.persistence.hibernate.UserDaoImpl;

@Path("/secure")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SecurityBoImpl implements SecurityBo {

	
	private UserDao userDao = new UserDaoImpl();
	
	private MenuDao menuDao = new MenuDaoImpl();

	@Override
	@GET
	@Path("/getUser/{userId}/{pass}/")
	public UserDto getUserByUserIdAndPassword(@PathParam("userId") String userId, @PathParam("pass") String password) {
		userDao.openSession();
		UserDto result = new UserDto(userDao.getUserByUserIdAndPassword(userId,password));
		userDao.closeSession();
		return result;
	}

	@Override
	public List<MenuDto> getMenusByUser(String userId) {
		List<MenuDto> result = new ArrayList<MenuDto>();
		menuDao.openSession();
		for(Menu m : menuDao.getMenusByUser(userId)) {
			result.add(new MenuDto(m));
		}
		menuDao.closeSession();
		return result;
	}

	@Override
	public MenuDto[] getMenusByUser2(String userId) {
		List<MenuDto> result = getMenusByUser(userId);
		if(result!=null) {
			return result.toArray(new  MenuDto[result.size()]);
		}else {
			return new MenuDto[0];
		}
		
	}
	
	

}
