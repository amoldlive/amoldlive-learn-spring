package com.data.jpa.association;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {

	private static final Logger LOG = LoggerFactory.getLogger(AppRunnerMain.class);

	@PersistenceContext
	EntityManager em;

	public Course findById(Long id) {
		Course course = em.find(Course.class, id);
		LOG.info("Course -> {}", course);
		return course;
	}

	public Course save(Course course) {

		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}

		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}

	public void playWithEntityManager() {
		Course course1 = new Course("Web Services in 100 Steps");
		em.persist(course1);

		Course course2 = findById(10001L);

		course2.setName("JPA in 50 Steps - Updated");

	}

	public void addHardcodedReviewsForCourse() {
		// get the course 10003
		Course course = findById(1L);
		LOG.info("course.getReviews() -> {}", course.getReviews());

		// add 2 reviews to it
		Review review1 = new Review("Great Hands-on Stuff.");
		Review review2 = new Review("Hatsoff.");

		// setting the relationship
		course.addReview(review1);
		review1.setCourse(course);

		course.addReview(review2);
		review2.setCourse(course);

		// save it to the database
		em.persist(review1);
		em.persist(review2);
	}

	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		LOG.info("course.getReviews() -> {}", course.getReviews());
		for (Review review : reviews) {
			// setting the relationship
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
	}
}
