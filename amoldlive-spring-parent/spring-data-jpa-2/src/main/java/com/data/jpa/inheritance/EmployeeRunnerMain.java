package com.data.jpa.inheritance;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRunnerMain implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeRunnerMain.class);

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		PartTimeEmployee employee=new PartTimeEmployee("Jack", new BigDecimal("50"));
		FullTimeEmployee employee2=new FullTimeEmployee("Jill", new BigDecimal("2000"));
			
		employeeRepository.save(employee);
		employeeRepository.save(employee2);
	}



}
