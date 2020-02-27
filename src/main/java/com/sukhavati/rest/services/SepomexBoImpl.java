/**
 * 
 */
package com.sukhavati.rest.services;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sukhavati.layer.bo.SepomexBo;
import com.sukhavati.layer.dao.SepomexDao;
import com.sukhavati.models.dao.Sepomex;
import com.sukhavati.persistence.hibernate.SepomexDaoImpl;

/**
 * @author Equipo1
 *
 */
@Path("/sepomex")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SepomexBoImpl implements SepomexBo {
	
	private static SepomexDao sepomexDao = new SepomexDaoImpl();

	/* (non-Javadoc)
	 * @see com.sukhavati.layer.bo.SepomexBo#findByZipCode(java.lang.String)
	 */
	@Override
	@GET
	@Path("/findByZipCode/{zipCode}/")
	public List<Sepomex> findByZipCode(@PathParam("zipCode")  String zipCode) {
		sepomexDao.openSession();
		List<Sepomex> res = sepomexDao.findAllBy("zipCode", zipCode);
		sepomexDao.closeSession();
		return res;
	}

}
