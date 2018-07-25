package com.java.spring.hibernate.rest.dao.impl;

import java.util.List;

import com.java.spring.hibernate.rest.dao.StudentDAO;
import com.java.spring.hibernate.rest.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createStudent(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student getStudentById(long id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> getAllStudents() {
		return entityManager.createQuery("select stu from Student stu").getResultList();
	}

	@Override
	public void updateStudent(Student student) {
		entityManager.merge(student);
	}

	@Override
	public void deleteStudent(long id) {
		Student s = entityManager.find(Student.class, id);
		entityManager.remove(s);
	}
}