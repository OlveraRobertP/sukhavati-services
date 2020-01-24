package com.sukhavati.models.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "")
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8071026029856166465L;

	@Id
	@Column (name = "", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer menuId;
	
	@Column (name = "")
	private String label; 
	
	@Column (name = "")
	private String icon;
	
	@Column (name = "")
	private String routerLink;
	
	@Column (name = "")
	private Boolean IsChildVisible;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		return true;
	}
	
	

}
