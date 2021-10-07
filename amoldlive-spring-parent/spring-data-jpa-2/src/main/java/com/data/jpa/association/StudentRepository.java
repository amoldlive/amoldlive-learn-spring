package com.data.jpa.association;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {

	private static final Logger LOG = LoggerFactory.getLogger(AppRunnerMain.class);

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void truncateTable() {
		String query2 = "truncate TABLE student";
		String query1 = "truncate TABLE passport";
		entityManager.createNativeQuery(query1).executeUpdate();
		entityManager.createNativeQuery(query2).executeUpdate();
	}

	public void saveStudentWithPassport(Student student, Passport passport) {
		entityManager.persist(passport);
		entityManager.persist(student);
		System.out.println("Student inserted -> 1");
	}

	public Student find(int id) {
		return entityManager.find(Student.class, id);
	}

	/* Entity chanegs will be auto merge and pushed to DB */
	public void someTest_1() {

		/* Database Operation -1 -> Retrieve Student */
		Student student = entityManager.find(Student.class, 1);
		LOG.info("Student - > " + student);

		/* Database Operation -2 -> Retrieve Passport */
		Passport passport = student.getPassport();
		LOG.info("Passport - > " + passport);

		/* Database Operation -3 -> Update Student */
		student.setName("Amol D Live");
		LOG.info("Student name updated  -> " + student);

		/* Database Operation -4 -> Update Passport */
		passport.setNumber("Ex12376");
		LOG.info("Passport number updated  -> " + passport);

	}

	public void fetch_Student_Form_Passport() {
		Passport passport = entityManager.find(Passport.class, 2);
		LOG.info("passport - > " + passport);
		
		//get student
		Student student=passport.getStudent();
		LOG.info("Student - > " + student);
		
		//update student
		student.setName("Polo Alto");
	}
}
