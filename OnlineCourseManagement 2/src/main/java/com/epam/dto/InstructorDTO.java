package com.epam.dto;

import java.util.*;

public class InstructorDTO {
	private String name;
	private String email;
	private String username;
	private String password;
	private List<CourseDTO> courseList;

	public InstructorDTO() {

	}

	public InstructorDTO(String name, String email, String username, String password, List<CourseDTO> courseList) {
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.courseList = courseList;

	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public List<CourseDTO> getCourseList() {
		return courseList;
	}
	

	public String toString() {
		return "Instructor Name : "+name + "\n" +"Email : "+ email + "\n" +"Username : "+username + "\n" +"Pssword : "+ password + "\n" +"Course List : "+ courseList+"\n";
	}

}
