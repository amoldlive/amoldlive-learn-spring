package com.data.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {

	@PersistenceContext
	EntityManager entityManager;

	public void save(Student student) {
		entityManager.persist(student);
		System.out.println("Student ***  Saved");
		
	}
}
