package com.epam.service;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dto.*;

public class CourseService {

	InstructorDTO instructor = null;
	private static final Logger LOGGER = LogManager.getLogger(CourseService.class);

	public CourseService(InstructorDTO instructor) {

		this.instructor = instructor;

	}

	public void addCourse(CourseDTO course) throws NullPointerException{
		List<CourseDTO> courseList = instructor.getCourseList();
		if (course == null) {
			throw new NullPointerException("null course");
		} else {
			boolean flag = false;
			for (CourseDTO c : courseList) {
				if (c.getCourseId().equalsIgnoreCase(course.getCourseId())
						&& c.getCourseName().equalsIgnoreCase(course.getCourseName())) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				courseList.add(course);
				LOGGER.info("successfully added course to {}", instructor.getName());
			} else {
				LOGGER.info("can't add course as course already exists");
			}
		}

	}

	public int getSize() {
		List<CourseDTO> courseList = instructor.getCourseList();
		return courseList.size();
	}

	public boolean deleteCourse(String courseName) {
		List<CourseDTO> courses = instructor.getCourseList();

		return courses.removeIf(c -> c.getCourseName().equalsIgnoreCase(courseName));
		
	}

	public void viewCourse() {
		List<CourseDTO> courses = instructor.getCourseList();
		
		LOGGER.debug("The list of courses \n");
		for (CourseDTO c : courses) {
			LOGGER.info(c);
		}
		
	}

}
