package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Person;

import com.example.demo.service.personService;

@Controller
public class personController {

	@Autowired
	private personService perservice;
	
	@GetMapping("/")
	public String ViewHomePage(Model md) {
		md.addAttribute("listPerson", perservice.getAllPerson());
		return "index";
	}
	//-------show-------//
	@GetMapping("/shownewPerson")
	public String shownewPerson(Model md) {
	Person person=new Person();
	md.addAttribute("person", person);
	return "new_person";
	}
	
	//-----save----------//
	@PostMapping("/savePerson")
	public String savePerson(@ModelAttribute("person") Person person)
	{
		perservice.savePerson(person);
		return "redirect:/";		
	}
	
	//---------------Update-----------------
		@GetMapping("/showFormForUpdate/{id}")
		public String showFormForUpdate(@PathVariable(value = "id") long id, Model md)
		{
			Person person = perservice.getPersonId(id);
			md.addAttribute("person", person);	
			return "update_person";		
		}
		//----------------------Delete----------
		@GetMapping("/deletePerson/{id}")
		public String deletePerson(@PathVariable(value = "id") long id)
		{
			this.perservice.deletePersonById(id);
			return "redirect:/";	
		}
	
}
