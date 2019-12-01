package com.tj.project2.dao;

import java.util.List;

import com.tj.project2.entity.Person;



public interface PersonDAO {
	
	public List<Person> findAll();
	
	public Person findBYID(int theId);
	
	public void save(Person thePerson);
	
	public void deleteById(int theId);

}
