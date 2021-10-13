package com.data.dao.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.data.entity.Student;

@Repository
@Transactional 
//@Transactional- JTA- java transaction API support for managing transactions such as commit , rollback 
public class StudentRepository implements IStudentRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public void update(Student student, Long studentId) {
		Student studentFromDB = entityManager.find(Student.class, studentId);
		studentFromDB.setName(student.getName());
		entityManager.flush();
	}

	@Override
	public Student get(Long studentId) {
		Student student = entityManager.find(Student.class, studentId);
		return student;
	}

	@Override
	public void delete(Long studentId) {
		entityManager.remove(entityManager.find(Student.class, studentId));
	}
}
