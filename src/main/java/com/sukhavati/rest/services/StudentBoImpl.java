/**
 * 
 */
package com.sukhavati.rest.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Transaction;

import com.sukhavati.layer.bo.StudentBo;
import com.sukhavati.layer.dao.StudentDao;
import com.sukhavati.models.dao.Student;
import com.sukhavati.models.dto.StudentDto;
import com.sukhavati.persistence.hibernate.StudentDaoImpl;
import com.sukhavati.secure.AuthToken;
import com.sukhavati.utils.DateFormat;
import com.sukhavati.utils.TypeFormatDate;

/**
 * @author jrobolvp
 *
 */
@Path("/student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentBoImpl implements StudentBo {
	
	private static StudentDao studentDao = new StudentDaoImpl();
	
	@Override
	@GET
	@Path("/list/")
	public List<StudentDto> getAll() {
		List<StudentDto> result = new ArrayList<StudentDto>();
		try {
			studentDao.openSession();
			for(Student m : studentDao.findAllOrderByName()) {
				result.add(new StudentDto(m,false));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			studentDao.closeSession();
		}
		return result;
	}
	
	@Override
	@GET
	@Path("/getById/{id}")
	public StudentDto getById(@PathParam("id") Integer id) {
		try {
			studentDao.openSession();
			return  new StudentDto(studentDao.findById(id),true);			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			studentDao.closeSession();
		}
		return null;
	}

	@Override
	//@POST
	@PUT
	@Path("/save/")
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response saveOrUpdate(StudentDto student,@HeaderParam("Authorization") String authString) {
		StudentDto stud = student;
		try {
			studentDao.openSession();
			if(student.getId() == null || student.getId() == 0) {
				//validar rfc
				if(studentDao.findBy("rfc", student.getRfc()) != null) {
					return Response.status(Response.Status.BAD_REQUEST).entity("Ya existe el alumno").build();
				}
			}
			Transaction tx = studentDao.beginTransaction();
			Student s = fromDto(student);
			s.setModDate(new Date());
			s.setModUser(AuthToken.getUserByAuth(authString));
			studentDao.saveOrUpdate(s);
			tx.commit();
			stud = new StudentDto(s, true);
		}catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); 
		}finally {
			studentDao.closeSession();
		}
		return Response.status(Response.Status.OK).entity(stud).build(); 
	}
	
	private Student fromDto(StudentDto s) throws ParseException {
		Student res = new Student();
		res.setId(s.getId());
		res.setFirstName(s.getName());
		res.setLastName(s.getLastName());
		try {
			res.setBirthDate(DateFormat.toDate(s.getBirthDate(),TypeFormatDate.SHORT));
		}catch(java.text.ParseException e) {
			res.setBirthDate(DateFormat.toDate(s.getBirthDate(),TypeFormatDate.FULL));
		}
		res.setRfc(s.getRfc());
		res.setEmail(s.getEmail());
		res.setMobileNumber(s.getMobileNumber());
		res.setPhoneNumber(s.getPhoneNumber());
		res.setAddress(s.getAddress());
		res.setGender(s.getGender());
		if(s.getSepomex() != null && s.getSepomex().getId() != null) {
			res.setSepomex(s.getSepomex());
		}		
		res.setMaritalStatus(s.getMaritalStatus());
		res.setComments(s.getComments());
		res.setExtraComments(s.getExtraComments());
		res.setPhoto(s.getPhoto());
		return res;
	}

}
