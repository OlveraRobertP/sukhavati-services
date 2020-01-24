package com.sukhavati.models.dto;

import java.io.Serializable;

import com.sukhavati.models.dao.Menu;

import lombok.Data;

@Data
public class MenuDto implements Serializable{

	private String label;
	private String icon;
	private String routerLink;
	private Boolean isChildVisible;
	
	public MenuDto() {
	}
	
	public MenuDto(Menu menu) {
		if(menu!=null) {
			this.label = menu.getLabel();
			this.icon = menu.getIcon();
			this.routerLink = menu.getRouterLink();
			this.isChildVisible = menu.getIsChildVisible();
		}		
	}

}
