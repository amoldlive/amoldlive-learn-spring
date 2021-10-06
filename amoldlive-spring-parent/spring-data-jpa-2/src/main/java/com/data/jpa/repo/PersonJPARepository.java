package com.data.jpa.repo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.data.entity.Person;
import com.data.jdbc.dao.Pupil;

@Repository
@Transactional
public class PersonJPARepository {

	@PersistenceContext
	EntityManager entityManager;

	public List<Pupil> findAll() {
		return null;
	}

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public void insert(Person person) {
		entityManager.persist(person);
	}

	public void update(Person person) {
		entityManager.merge(person);
	}

	// delete
	public void deleteById(int id) {
		entityManager.remove(entityManager.find(Person.class, id));
	}
}
