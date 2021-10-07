package com.data.jpa.em;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component   // uncomment to execute
public class PersonJPARunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(PersonJPARepository.class);

	@Autowired
	PersonJPARepository personJPARepository;

	@Override
	public void run(String... args) throws Exception {
		
		personJPARepository.truncateTable();
		
		logger.info("\n inserting new Person data ->");
		personJPARepository.insert(new Person("Amol Dhawale", "Nagpur", new Date()));
		personJPARepository.insert(new Person("Priya Pande", "Nagpur", new Date()));
		personJPARepository.insert(new Person("Dw Doa", "Us", new Date()));
		logger.info("\n Person inserted successfully <-");

		logger.info("\n Person data for ID 1  ->  " + personJPARepository.findById(1));

		logger.info("\n deleting data for ID 2  ->  ");
		personJPARepository.deleteById(2);

		logger.info("\n updating data for ID 3  ->  ");
		personJPARepository.update(new Person("John Sena", "Us", new Date()), 3);

		logger.info("\n Getting All Persons  ->  " + personJPARepository.findAll());

	}

}
