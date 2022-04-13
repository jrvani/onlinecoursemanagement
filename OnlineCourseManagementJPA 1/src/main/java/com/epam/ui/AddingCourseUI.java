package com.epam.ui;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import com.epam.entity.*;



public class AddingCourseUI {
	private static final Logger LOGGER=LogManager.getLogger(AddingCourseUI.class);
	public Course addCourse() {
		Scanner sc = new Scanner(System.in);
			LOGGER.debug("Enter Course Name");
			String courseName = sc.next();
			LOGGER.debug("Enter Course Description");
			sc.nextLine();
			String courseDescription = sc.nextLine();
			LOGGER.debug("Enter Course Duration");
			int courseDurationInMonths = sc.nextInt();
			
			List<Assignment> ass=new ArrayList<>();
			return new Course(courseName, courseDescription, courseDurationInMonths,ass);
		
		

		

	}

}
