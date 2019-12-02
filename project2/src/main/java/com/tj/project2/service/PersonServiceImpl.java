package com.tj.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj.project2.dao.PersonDAO;
import com.tj.project2.entity.Person;


@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;
	
	@Autowired
	public PersonServiceImpl(PersonDAO thePersonDAO) {
		personDAO = thePersonDAO;
	}
	
	@Override
	@Transactional
	public List<Person> findAll() {
		
		return personDAO.findAll();
	}

	@Override
	@Transactional
	public Person findBYID(int theId) {
		return personDAO.findBYID(theId);
	}

	@Override
	@Transactional
	public void save(Person thePerson) {
		personDAO.save(thePerson);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		personDAO.deleteById(theId);
		
	}

}
