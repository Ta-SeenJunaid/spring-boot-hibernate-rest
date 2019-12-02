package com.tj.project2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tj.project2.entity.Person;
import com.tj.project2.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonRestController {
	
	private PersonService personService;
	
	@Autowired
	public PersonRestController(PersonService thePersonService) {
		
		personService = thePersonService;
	}
	
	@GetMapping("/persons")
	public List<Person> findAll(){
		return personService.findAll();
	}
	
	@GetMapping("/persons/{personId}")
	public Person getEmployee(@PathVariable int personId) {
		
		Person theperson = personService.findBYID(personId);
		
		if(theperson == null) {
			throw new RuntimeException("Person id not found - " + personId);
		}
		
		return theperson;
	}
	
	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person thePerson) {
		
		thePerson.setId(0);
		
		personService.save(thePerson);
		
		return thePerson;
	}
	
	@PutMapping("/persons")
	public Person updateEmployee(@RequestBody Person thePerson) {
		
		personService.save(thePerson);
		
		return thePerson;
	}
	
	@DeleteMapping("/persons/{personId}")
	public String deletePerson(@PathVariable int personId) {
		Person tempPerson = personService.findBYID(personId);
		
		if (tempPerson == null) {
			throw new RuntimeException("Person id not found - "+ personId);
		}
		
		personService.deleteById(personId);
		
		return "Deleted employee id - " + personId;
		
	}
	
	

}
