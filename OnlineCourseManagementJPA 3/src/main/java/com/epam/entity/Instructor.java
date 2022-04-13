package com.epam.entity;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instructor_id")
	private int instructorId;
	@Column(name="instructor_name")
	private String name;
	@Column(name="instructor_username")
	private String username;
	@Column(name="instructor_password")
	private String password;
	
	@OneToMany(mappedBy = "instructor",cascade = CascadeType.ALL )
	private List<Course> courseList;

	
    public Instructor()
    {
    	
    }
	public Instructor(String name, String username, String password, List<Course> courseList) {
		
		this.name = name;
		this.username = username;
		this.password = password;
		this.courseList = courseList;

	}
   

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getInstructorId() {
		return instructorId;
	}


	public void setInstructorId(int instructorId) {
		this.instructorId=instructorId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Course> getCourseList() {
		return courseList;
	}


	public void setCourseList(List<Course> courseList) {
		courseList.stream().forEach(c->c.setInstructor(this));
		this.courseList = courseList;
	}

	public String toString()
	{
		return instructorId+" "+name;
	}
	

}
