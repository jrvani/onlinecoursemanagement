package com.epam.service;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dto.*;

// add modify logic
public class CourseService {
	
	InstructorDTO instructor = null;
	private static final Logger LOGGER=LogManager.getLogger(CourseService.class);

	public CourseService(InstructorDTO instructor) {
		
		this.instructor = instructor;

	}

	public void addCourse(CourseDTO course) {
		List<CourseDTO> courseList = instructor.getCourseList();
		courseList.add(course);
        
		LOGGER.debug("successfully added course to {}",instructor.getName());

	}

	public void deleteCourse(String courseName) {
			List<CourseDTO> courses = instructor.getCourseList();
            boolean b=courses.removeIf(c->c.getCourseName().equalsIgnoreCase(courseName));
			if(b) {
			LOGGER.debug(" sucessfully deleted course ");
			}
			else {
				LOGGER.debug("unable to delete:No match found");
			}
	

	}

	public void viewCourse() {
		List<CourseDTO> courses = instructor.getCourseList();
		LOGGER.debug("The list of courses \n");
		for(CourseDTO c: courses) {
		LOGGER.info(c);
		}

	}

}
