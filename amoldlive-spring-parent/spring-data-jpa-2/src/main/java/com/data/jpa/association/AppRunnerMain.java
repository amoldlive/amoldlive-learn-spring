package com.data.jpa.association;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunnerMain implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(AppRunnerMain.class);

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

				
		Passport passport1 = new Passport("E123451");
		Passport passport2 = new Passport("E123452");
		Passport passport3 = new Passport("E123453");
		Passport passport4 = new Passport("E123454");

		Student student1 = new Student("Amol Dhawale", passport1);
		Student student2 = new Student("John Dao", passport2);
		Student student3 = new Student("Shan Mitra", passport3);
		Student student4 = new Student("Karan Kundra", passport4);

		//studentRepository.saveStudentWithPassport(student1, passport1);
		//studentRepository.saveStudentWithPassport(student2, passport2);
		//studentRepository.saveStudentWithPassport(student3, passport3);
		//studentRepository.saveStudentWithPassport(student4, passport4);
		
		//LOG.info("\n All Students - > "+ studentRepository.findAll());
		
		LOG.info("\nStudent Data For - 1  - > "+ studentRepository.find(1));
		
		studentRepository.someTest_1();
		
		studentRepository.fetch_Student_Form_Passport();
	}

}
