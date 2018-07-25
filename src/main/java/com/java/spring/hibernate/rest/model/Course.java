package com.java.spring.hibernate.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "COURSE")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Course")
public class Course implements Serializable{
	private static final long serialVersionUID = -1232395859408322327L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "COURSE_ID", updatable = false, nullable = false)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name ="CODE")
	private String code;
	
	public Course() {
		super();
	}
	
	public Course(long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
