package com.data.jpa.inheritance;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

	@Column
	BigDecimal hourlyWages;

	public PartTimeEmployee(String name, BigDecimal hourlyWages) {
		super.name = name;
		this.hourlyWages = hourlyWages;
	}

	public BigDecimal getHourlyWages() {
		return hourlyWages;
	}

	public void setHourlyWages(BigDecimal hourlyWages) {
		this.hourlyWages = hourlyWages;
	}

	@Override
	public String toString() {
		return "\nPartTimeEmployee [hourlyWages=" + hourlyWages + ", name=" + name + "]";
	}

	
}
