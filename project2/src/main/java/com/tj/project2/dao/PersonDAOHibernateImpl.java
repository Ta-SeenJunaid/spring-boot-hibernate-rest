package com.tj.project2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.project2.entity.Person;

@Repository
public class PersonDAOHibernateImpl implements PersonDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public PersonDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Person> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Person> theQuery = 
				currentSession.createQuery("from Person", Person.class);
		
		List<Person> persons = theQuery.getResultList();
		
		return persons;
	}

	@Override
	public Person findBYID(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Person thePerson = 
				currentSession.get(Person.class, theId);
		
		return thePerson;
	}

	@Override
	public void save(Person thePerson) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(thePerson);
		
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = 
				currentSession.createQuery(
						"delete from Person where id=:personId");
		theQuery.setParameter("personId", theId);
		
		theQuery.executeUpdate();
		
	}

}
