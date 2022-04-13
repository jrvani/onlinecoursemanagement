package com.epam.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Course {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cid")
	private  int courseId;
	@Column(name="course_name")
	private String courseName;
	@Column(name="course_description")
	private  String courseDescription;
	@Column(name="duration")
	private  int courseDurationInMonths;
	@ManyToOne
	private Instructor instructor;
	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
	private  List<Assignment> assignments;
	
	

	public Course()
	{
		
	}
	public Course(String courseName,  String courseDescription, int courseDurationInMonths,List<Assignment> assignments) {
		this.courseName = courseName;
		
		this.courseDescription = courseDescription;
		this.courseDurationInMonths = courseDurationInMonths;
		this. assignments= assignments;

	}

	
  
	public Instructor getInstructor() {
		return instructor;
	}



	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	


	public  String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
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



	public List<Assignment> getAssignments() {
		return assignments;
	}



	public void setAssignments(List<Assignment> assignments) {
		assignments.stream().forEach(a->a.setCourse(this));
		this.assignments = assignments;
	}

	public String toString() {
		return courseId+"Course Name : "+courseName +"\n" +"Course Description : "+ courseDescription + "\n" +"Course Duration In Months : "+ courseDurationInMonths + "\n"+"Assignments : "+assignments+"\n";
	}
	
	

	

}

