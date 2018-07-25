package com.java.spring.hibernate.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.spring.hibernate.rest.dao.CourseDAO;
import com.java.spring.hibernate.rest.model.Course;

@Service("courseService")
@Transactional(propagation = Propagation.REQUIRED)
public class CourseService {
	
	@Autowired
	CourseDAO courseDAO;
	
	@Transactional
	public void createCourse(Course course) {
		courseDAO.createCourse(course);
	}
	
	@Transactional
	public Course getCourse(long id) {
		return courseDAO.getCourse(id);
	}
	
	@Transactional
	public List<Course> getAllCourses(){
		return courseDAO.getAllCourse();
	}
	
	@Transactional
	public void updateCourse(Course course) {
		courseDAO.updateCourse(course);
	}
	
	@Transactional
	public void deleteCourse(long id) {
		courseDAO.deleteCourse(id);
	}

}
