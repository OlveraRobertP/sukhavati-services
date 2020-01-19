package com.sukhavati.services;

import javax.ws.rs.core.Response;

import com.sukhavati.models.Person;

public interface PersonService {

	public Response addPerson(Person p);
	
	public Response deletePerson(int id);
	
	public Person getPerson(int id);
	
	public Person[] getAllPersons();

}