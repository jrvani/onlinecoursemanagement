package com.epam.service;

import java.util.*;

import com.epam.dao.InstructorDAO;

import com.epam.dto.*;

// add modify logic
public class CourseService {
	String username;
	InstructorDTO instructor = null;

	public CourseService(String username, InstructorDTO instructor) {
		this.username = username;
		this.instructor = instructor;

	}

	public void addCourse(CourseDTO course) {
		List<CourseDTO> courseList = instructor.getCourseList();
		courseList.add(course);

		System.out.println("successfully added course " + instructor);

	}

	public void deleteCourse(String courseName) {
		if (instructor != null) {
			List<CourseDTO> courses = instructor.getCourseList();
            CourseDTO course=courses.stream().filter(c->c.getCourseName().equals(courseName)).findAny().get();
            courses.remove(course);
			/*for (CourseDTO c : courses) {
				if (c.getCourseName().equals(courseName)) {
					courses.remove(c);
					break;
				}
			}*/

			System.out.println(" sucessfully deleted course ");
		}

	}

	public void viewCourse() {
		List<CourseDTO> courses = instructor.getCourseList();
		System.out.println(courses);

	}

}
