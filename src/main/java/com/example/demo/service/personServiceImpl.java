package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.repository.personRepository;

@Service
public class personServiceImpl implements personService{
	
	@Autowired
	private personRepository perrepository;

	@Override
	public List<Person> getAllPerson() {
		
		return perrepository.findAll() ;
	}

	@Override
	public void savePerson(Person person) {
	
		this.perrepository.save(person);
		
	}

	@Override
	public Person getPersonId(long id) {
		Optional<Person> optional = perrepository.findById(id);
		Person person=null;
		if(optional.isPresent())
		{
			person = optional.get();
		}
		else
		{
			throw new RuntimeException("Person not found for id ::"+id);
		}
		return person;
	}

	@Override
	public void deletePersonById(long id) {
		
		this.perrepository.deleteById(id);;
		
	}
	
	

}
