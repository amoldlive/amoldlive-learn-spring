package com.data.runner.clr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.data.dao.entitymanager.StudentRepository;
import com.data.entity.Student;

@Component
public class StudentRunner implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(StudentRepository.class);

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		
		LOG.info("Saving student");
		Student student = new Student();
		student.setName("Amol");
		
		Student student2 = new Student();
		student.setName("Dipalini");
		
		studentRepository.save(student);
		studentRepository.save(student2);
		
		LOG.info("Student Save");
		
		
		LOG.info("Getting student");
		Student studentFromDB = studentRepository.get(2L);
		LOG.info("Got Student from DB : "+studentFromDB);
		
		
		LOG.info("updating student");
		Student student3=new Student();
		student3.setName("Ranjha");
		studentRepository.update(student3, 2L);
		LOG.info("Updated Student ");
		
		LOG.info("Deleting student");
		studentRepository.delete(1L);
		LOG.info("Deleting Student ");
	}

}
