package com.data.jpa.association;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "number")
	String number;

	/*mapped by ->joint id column is already created in passport entity*/
	//Passport passport(literal whis is used as reference in mapped by);
	@OneToOne(mappedBy = "passport") 
	Student student;
	
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "\nPassport [ number=" + number + "]";
	}

}
