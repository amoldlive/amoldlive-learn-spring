package com.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.data")
public class SpringDataJpa2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpa2Application.class, args);
	}

}