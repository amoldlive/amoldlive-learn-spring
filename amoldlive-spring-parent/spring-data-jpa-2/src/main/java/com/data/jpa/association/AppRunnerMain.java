package com.data.jpa.association;

import java.util.ArrayList;
import java.util.List;

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

	@Autowired
	CourseRepository courseRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		/* uncomment to check student entity operatiosn */
		// studenRepoAction();
		
		/* uncomment to check student entity operatiosn */
		//courseRepoAction();
	}

	public void courseRepoAction() {
		Course course =new Course("Learn Java in 10 min");
		Course course2 =new Course("Learn SQL in 10 min");
		
		List<Review> reviews=new ArrayList<>();
		reviews.add(new Review("Very Good course"));
		reviews.add(new Review("just Loved This"));
		reviews.add(new Review("clear instructions"));
		
		courseRepository.save(course);
		courseRepository.save(course2);
		//courseRepository.saveReviews(reviews);
		
		courseRepository.addHardcodedReviewsForCourse();
	}

	public void studenRepoAction() {
		Passport passport1 = new Passport("E123451");
		Passport passport2 = new Passport("E123452");
		Passport passport3 = new Passport("E123453");
		Passport passport4 = new Passport("E123454");

		Student student1 = new Student("Amol Dhawale", passport1);
		Student student2 = new Student("John Dao", passport2);
		Student student3 = new Student("Shan Mitra", passport3);
		Student student4 = new Student("Karan Kundra", passport4);

		// studentRepository.saveStudentWithPassport(student1, passport1);
		// studentRepository.saveStudentWithPassport(student2, passport2);
		// studentRepository.saveStudentWithPassport(student3, passport3);
		// studentRepository.saveStudentWithPassport(student4, passport4);

		// LOG.info("\n All Students - > "+ studentRepository.findAll());

		LOG.info("\nStudent Data For - 1  - > " + studentRepository.find(1));

		studentRepository.someTest_1();

		studentRepository.fetch_Student_Form_Passport();
	}

}
