package com.java.spring.hibernate.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.hibernate.rest.model.Student;
import com.java.spring.hibernate.rest.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	/*** Creating a new Student ***/
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void createStudent(@RequestBody Student student) {
		studentService.createStudent(student);
	}

	/*** Retrieve a single Student ***/
	@RequestMapping(value = "/student/{id}", produces = "application/json", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") long id) {
		Student student = studentService.getStudentById(id);
		return student;
	}

	/*** Retrieve all Students ***/
	@RequestMapping(value = "/students", produces = "application/json", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		return studentList;
	}

	/*** Update a Student ***/
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
	}

	/*** Delete a Student ***/
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteStudent(@PathVariable("id") long id) {
		studentService.deleteStudent(id);
	}
}