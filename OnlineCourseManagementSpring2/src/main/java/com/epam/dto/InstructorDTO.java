package com.epam.dto;

import java.util.*;

import org.springframework.stereotype.Component;
@Component
public class InstructorDTO {
	private String name;
	private int instructorId;
	private String username;
	private String password;
	private List<CourseDTO> courseList;

	
    public InstructorDTO()
    {
    	
    }
	public InstructorDTO(String name, String username, String password, List<CourseDTO> courseList) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.courseList = courseList;

	}
    public void setName(String name) {
		this.name = name;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public String getName()
    {
    	return name;
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
	
	public void setCourseList(List<CourseDTO> courseList ) {
		this.courseList= courseList;
	}
	

	public String toString() {
		return "Instructor Name : "+name + "\n" +"Username : "+username + "\n" +"Pssword : "+ password + "\n" +"Course List : "+ courseList+"\n";
	}

}
