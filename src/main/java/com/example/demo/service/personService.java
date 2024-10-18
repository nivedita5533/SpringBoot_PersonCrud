package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Person;

public interface personService {
	
	List<Person> getAllPerson();
	void savePerson(Person person);
	Person getPersonId(long id);
	void deletePersonById(long id);

}
