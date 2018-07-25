package com.java.spring.hibernate.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.spring.hibernate.rest.model.Course;

@Repository
public interface CourseDAO {
	public void createCourse(Course course );
	
	public Course getCourse(long id);
	
	public List<Course> getAllCourse();
	
	public void updateCourse (Course course);
	
	public void deleteCourse(long id);

}
