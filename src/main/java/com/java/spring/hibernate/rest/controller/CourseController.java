package com.java.spring.hibernate.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.hibernate.rest.model.Course;
import com.java.spring.hibernate.rest.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "/create-course", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void createCourse(@RequestBody Course course) {
		courseService.createCourse(course);
	}

	/*** Retrieve a single Student ***/
	@RequestMapping(value = "/course/{id}", produces = "application/json", method = RequestMethod.GET)
	public Course getCourseById(@PathVariable("id") long id) {
		return courseService.getCourse(id);
	}

	/*** Retrieve all Students ***/
	@RequestMapping(value = "/courses", produces = "application/json", method = RequestMethod.GET)
	public List<Course> getAllStudents() {
		List<Course> courseList = courseService.getAllCourses();
		return courseList;
	}

	/*** Update a Student ***/
	@RequestMapping(value = "/update-course", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateCourse(@RequestBody Course course) {
		courseService.updateCourse(course);
	}

	/*** Delete a Student ***/
	@RequestMapping(value = "/delete-course/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteStudent(@PathVariable("id") long id) {
		courseService.deleteCourse(id);
	}	

}
