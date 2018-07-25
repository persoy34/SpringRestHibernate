package com.java.spring.hibernate.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.spring.hibernate.rest.model.Student;


@Repository
public interface StudentDAO
{
    public void createStudent(Student student);
    
    public Student getStudentById(long id);
    public List<Student> getAllStudents();
    
    public void updateStudent(Student student);
    
    public void deleteStudent(long id);
}