package com.sukhavati.models.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "zu_clientes")
public class Student  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -884947180143371656L;

	@Id
	@Column (name = "codigo_cliente", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nombre")
	private String firstName; 
	
	@Column (name = "apellidos")
	private String lastName;
	
	@Column (name = "fecha_nacimiento")
	private Date birthDate;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "rfc")
	private String rfc;
	
	@Column (name = "celular")
	private String mobileNumber;
	
	@Column (name = "telefono")
	private String phoneNumber;
	
	@Column (name = "direccion")
	private String address;
	
	@Column (name = "codigo_postal")
	private String zipCode;
	
	@Column (name = "colonia")
	private String colonia;
	
	@Column (name = "municipio")
	private String region;
	
	@Column (name = "estado")
	private String city;
	
	@Column (name = "genero")
	private String gender;
	
	@Column (name = "estado_civil")
	private String maritalStatus;
	
	@Column (name = "Observaciones_1")
	private String comments;
	
	@Column (name = "Observaciones_2")
	private String extraComments;
	
	//@Lob
	@Column(name = "photo")
	private String photo;

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
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
