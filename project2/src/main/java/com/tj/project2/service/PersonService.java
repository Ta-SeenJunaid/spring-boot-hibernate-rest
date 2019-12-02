package com.tj.project2.service;

import java.util.List;

import com.tj.project2.entity.Person;

public interface PersonService {
	
	public List<Person> findAll();
	
	public Person findBYID(int theId);
	
	public void save(Person thePerson);
	
	public void deleteById(int theId);

}
