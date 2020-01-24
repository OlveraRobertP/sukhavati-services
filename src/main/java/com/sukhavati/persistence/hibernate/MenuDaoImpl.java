package com.sukhavati.persistence.hibernate;

import java.util.List;

import com.sukhavati.layer.dao.MenuDao;
import com.sukhavati.models.dao.Menu;

public class MenuDaoImpl extends PersistenceDaoImpl<Menu> implements MenuDao {

	@Override
	public List<Menu> getMenusByUser(String userId) {
		return super.getSession().createQuery(" u.menu From UserMenu u  where u.user.userId = :userId ")
				.setParameter("userId", userId)
				.list();
	}

}
