package com.data.jpa.association;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "name")
	String name;
	
	@OneToOne
	@JoinColumn(name="psprt_id") //joint column name - passport_id -> psprt_id
	Passport passport;

	
	
	public Student() {
		super();
	}

	public Student(String name, Passport passport) {
		super();
		this.name = name;
		this.passport = passport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "\nStudent [name=" + name + ", passport=" + passport + "]";
	}
	
	
	
	
}
