package com.epam.dto;

import java.util.List;

public class CourseDTO {
	String courseName;
	String courseId;
	String courseDescription;
	int courseDurationInMonths;
	List<String> topics;
	List<AssignmentsDTO> assignments;

	public CourseDTO(String courseName, String courseId, String courseDescription, int courseDurationInMonths,
			List<String> topics,List<AssignmentsDTO> assignments) {
		this.courseName = courseName;
		this.courseId = courseId;
		this.courseDescription = courseDescription;
		this.courseDurationInMonths = courseDurationInMonths;
		this.topics = topics;
		this. assignments= assignments;

	}

	public String getCourseName() {
		return courseName;
	}

	public List<String> getTopics() {
		return topics;
	}
	public List<AssignmentsDTO> getAssignments() {
		return assignments;
	}

	public String toString() {
		return "Course Name : "+courseName +"\n" +"Course ID : "+courseId + "\n" +"Course Description : "+ courseDescription + "\n" +"Course Duration In Months : "+ courseDurationInMonths + "\n" +"Topics : "+ topics+"\n"+"Assignments : "+assignments;
	}

}
