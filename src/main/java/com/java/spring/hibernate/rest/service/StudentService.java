package com.java.spring.hibernate.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.spring.hibernate.rest.dao.CourseDAO;
import com.java.spring.hibernate.rest.dao.StudentDAO;
import com.java.spring.hibernate.rest.model.Course;
import com.java.spring.hibernate.rest.model.Student;

@Service("studentService")
@Transactional(propagation = Propagation.REQUIRED)
public class StudentService {
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	CourseDAO courseDAO;
	
	@Transactional
	public void createStudent(Student student) {
		student.getCourses().forEach(course ->{
			Course course1 = courseDAO.getCourse(course.getId());
			if (course1 == null) {
				courseDAO.createCourse(course);
			}
		});
		studentDAO.createStudent(student);
	}
    
	@Transactional
	public Student getStudentById(long id) {
    	return studentDAO.getStudentById(id);
    }
	
	@Transactional
    public List<Student> getAllStudents(){
    	return studentDAO.getAllStudents();
    }
    
	@Transactional
    public void updateStudent(Student student) {
		student.getCourses().forEach(course ->{
			Course course1 = courseDAO.getCourse(course.getId());
			if (course1 == null) {
				courseDAO.createCourse(course);
			}
		});
    	studentDAO.updateStudent(student);
    }
    
	@Transactional
    public void deleteStudent(long id) {
    	studentDAO.deleteStudent(id);
    }
}
