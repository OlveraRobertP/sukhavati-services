
package com.sukhavati.rest.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sukhavati.models.Person;
import com.sukhavati.services.PersonService;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonServiceImpl implements PersonService {

	private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

	static {
		persons.put(1, new Person(1, "Roberto Olvera", 28));
		persons.put(2, new Person(2, "Maria Jimenez", 46));
		persons.put(3, new Person(3, "Ana Gonzalez", 19));
	}

	@POST
	@Path("/add")
	public Response addPerson(Person p) {
		Integer status;
		String msg;

		if (persons.get(p.getId()) != null) {
			status = 201;
			msg = "Person Already Exists";
		}

		persons.put(p.getId(), p);
		status = 201;
		msg = "Person created successfully";

		return Response.status(status).entity(msg).build();
	}

	@GET
	@Path("/{id}/delete")
	public Response deletePerson(@PathParam("id") int id) {
		Integer status;
		String msg;

		if (persons.get(id) == null) {
			status = 201;
			msg = "Person Doesn't Exists";
		}

		persons.remove(id);
		status = 201;
		msg = "Person deleted successfully";
		return Response.status(status).entity(msg).build();
	}

	@GET
	@Path("/{id}/get")
	public Person getPerson(@PathParam("id") int id) {
		return persons.get(id);
	}

	@GET
	@Path("/{id}/getDummy")
	public Person getDummyPerson(@PathParam("id") int id) {
		Person p = new Person();
		p.setAge(99);
		p.setName("Dummy");
		p.setId(id);
		return p;
	}

	@GET
	@Path("/getAll")
	public Person[] getAllPersons() {
		Set<Integer> ids = persons.keySet();
		Person[] p = new Person[ids.size()];
		int i = 0;
		for (Integer id : ids) {
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}

}