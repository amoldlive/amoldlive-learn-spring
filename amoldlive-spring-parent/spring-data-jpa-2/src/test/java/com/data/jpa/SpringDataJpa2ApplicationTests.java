package com.data.jpa;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.jpa.association.StudentRepository;


@SpringBootTest
class SpringDataJpa2ApplicationTests {
	
	private static final Logger LOG = LoggerFactory.getLogger(SpringDataJpa2ApplicationTests.class);
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@Transactional
	public void find() {
		LOG.info("\ntest case -1 | Student Data For - 1  - > "+ studentRepository.find(1));
	}
	
}
