package com.sukhavati.models.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author jrobolvp
 *
 */
@Data
@Entity
@Table(name = "zu_class_set")
public class ClassSet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4961805565869366355L;

	@Id
	@Column (name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "description")
	private String description;
	
	@Column (name = "effective_days")
	private Integer effectiveDays;
	
	@Column (name = "effective_class")
	private Integer ideffectiveClass;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassSet other = (ClassSet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	

}
