package com.sukhavati.layer.bo;

import java.util.List;

import com.sukhavati.models.dao.Sepomex;

public interface SepomexBo {
	
	/**
	 * Retorna el
	 * @param zipCode
	 * @return
	 */
	List<Sepomex> findByZipCode(String zipCode);
	
	
	
}
