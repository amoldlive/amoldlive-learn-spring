package com.data.jpa.association;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="description")
	private String description;

	@ManyToOne
	private Course course;

	protected Review() {
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "\nReview [description=" + description + ", course=" + course + "]";
	}

	

}