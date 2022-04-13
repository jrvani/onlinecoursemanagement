package com.epam.service;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.internal.build.AllowPrintStacktrace;

import com.epam.dao.CourseDAO;
import com.epam.entity.*;

public class CourseService {

	Instructor instructor = null;
	private static final Logger LOGGER = LogManager.getLogger(CourseService.class);
	CourseDAO courseDAO=new CourseDAO();
	int id;
	public CourseService(Instructor instructor) {

		this.instructor = instructor;
		id=instructor.getInstructorId();

	}

	public void addCourse(Course course) {
		
		course.setInstructor(instructor);
		courseDAO.add(course);
		System.out.println("successfully added");
		

	}

	public void deleteCourse(String courseName) {
		System.out.println(courseName);
		courseDAO.delete(id,courseName); 
		
	}

	public void viewCourse() {
		List<Course> list=courseDAO.view(id);
		for(Course c:list)
		{
			LOGGER.info(c);
		}
		
	}

}
