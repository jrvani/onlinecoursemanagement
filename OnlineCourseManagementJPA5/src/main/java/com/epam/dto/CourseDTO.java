package com.epam.dto;

import java.util.List;

public class CourseDTO {
	private int courseId;
	private  String courseName;
	private  String courseDescription;
	private  int courseDurationInMonths;
	

	private  List<AssignmentsDTO> assignments;

	public CourseDTO() {}
	public CourseDTO(String courseName, String courseDescription, int courseDurationInMonths,List<AssignmentsDTO> assignments) {
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseDurationInMonths = courseDurationInMonths;
		this. assignments= assignments;

	}

	public String getCourseName() {
		return courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public int getCourseDurationInMonths() {
		return courseDurationInMonths;
	}
	public void setCourseDurationInMonths(int courseDurationInMonths) {
		this.courseDurationInMonths = courseDurationInMonths;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<AssignmentsDTO> getAssignments() {
		return assignments;
	}

	public  void setAssignments(List<AssignmentsDTO> assignments) {
		this.assignments=assignments;
	}

	public String toString() {
		return "Course Name : "+courseName +"\n" +"Course Description : "+ courseDescription + "\n" +"Course Duration In Months : "+ courseDurationInMonths + "\n"+"Assignments : "+assignments+"\n";
	}

}
