package com.java.spring.hibernate.rest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java.spring.hibernate.rest.dao.CourseDAO;
import com.java.spring.hibernate.rest.model.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createCourse(Course course) {
		entityManager.persist(course);

	}

	@Override
	public Course getCourse(long id) {
		return entityManager.find(Course.class, id);
	}

	@Override
	public List<Course> getAllCourse() {
		return entityManager.createQuery("select course from Course course").getResultList();
	}

	@Override
	public void updateCourse(Course course) {
		entityManager.merge(course);

	}

	@Override
	public void deleteCourse(long id) {
		Course course =entityManager.find(Course.class, id);
		entityManager.remove(course);

	}

}
