package com.sukhavati.models.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "zu_sepomex")
public class Sepomex  implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 8177602491333198232L;

	@Id
	@Column (name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "cp")
	private String zipCode; 
	
	@Column (name = "asentamiento")
	private String colonia;
	
	@Column (name = "tipo_asentamiento")
	private String tipoAsentamineto;
	
	@Column (name = "municipio")
	private String region;
	
	@Column (name = "estado")
	private String city;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Sepomex other = (Sepomex) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
