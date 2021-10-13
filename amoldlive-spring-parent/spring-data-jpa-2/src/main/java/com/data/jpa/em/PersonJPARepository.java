package com.data.jpa.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJPARepository {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void truncateTable() {
	    String query = "truncate TABLE person";
	    entityManager.createNativeQuery(query).executeUpdate();
	}
	
	//find_all_persons - defined at entity level
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public void insert(Person person) {
		entityManager.persist(person);
		System.out.println("Rows inserted -> 1");
	}

	public void update(Person person, int id) {
		Person prsn = findById(id);
		prsn.setBirth_date(person.getBirth_date());
		prsn.setName(person.getName());
		prsn.setLocation(person.getLocation());
		entityManager.merge(prsn);
	}

	// delete
	public void deleteById(int id) {
		entityManager.remove(entityManager.find(Person.class, id));
	}
}
