package com.data.runner.clr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.data.entity.Student;
import com.data.repository.StudentRepository;

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
		studentRepository.save(student);
		LOG.info("Student Save");
	}

}
