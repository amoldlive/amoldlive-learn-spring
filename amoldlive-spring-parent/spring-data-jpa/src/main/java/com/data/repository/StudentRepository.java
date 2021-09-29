package com.data.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.data.entity.Student;

@Repository
@Transactional
public class StudentRepository implements IStudentRepository {

	@PersistenceContext
	EntityManager entityManager;

	
	@Override
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public void update(Student student, Long studentId) {
		
	}

	@Override
	public Student get(Long studentId) {
		Student student = entityManager.find(Student.class, studentId);
		return student;
	}

	@Override
	public void delete(Long studentId) {
		

	}
}
