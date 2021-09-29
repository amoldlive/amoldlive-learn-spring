package com.data.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Saving student");
		Student student=new Student();
		student.setName("Amol");
		studentRepository.save(student);
		System.out.println("Student Save");
	}

}
