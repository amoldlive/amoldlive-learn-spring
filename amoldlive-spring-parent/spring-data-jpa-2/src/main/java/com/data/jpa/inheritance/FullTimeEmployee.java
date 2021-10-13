package com.data.jpa.inheritance;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

	@Column
	BigDecimal salary;

	public FullTimeEmployee(String name, BigDecimal salary) {
		super.name = name;
		this.salary = salary;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "\nFullTimeEmployee [salary=" + salary + ", name=" + name + "]";
	}

}
