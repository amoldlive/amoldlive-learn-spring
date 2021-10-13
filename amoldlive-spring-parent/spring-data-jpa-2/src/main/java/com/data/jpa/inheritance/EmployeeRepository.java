package com.data.jpa.inheritance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeRepository {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeRepository.class);

	@PersistenceContext
	EntityManager entityManager;

	public void save(Employee employee) {
		entityManager.persist(employee);
		LOG.info("[ Employee inserted successfully ] ");
	}
	
	public List<Employee> getAllEmployee(){
		return entityManager.createQuery("SELECT E FROM EMPLOYEE",Employee.class).getResultList();
	}
}
