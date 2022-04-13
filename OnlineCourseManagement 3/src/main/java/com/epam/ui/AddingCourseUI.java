package com.epam.ui;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;


public class AddingCourseUI {
	private static final Logger LOGGER=LogManager.getLogger(AddingCourseUI.class);
	public CourseDTO addCourse() {
		Scanner sc = new Scanner(System.in);
			LOGGER.debug("Enter Course Name");
			String courseName = sc.next();
			LOGGER.debug("Enter Course Id");
			String courseId = sc.next();
			sc.nextLine();
			LOGGER.debug("Enter Course Description");
			String courseDescription = sc.nextLine();
			LOGGER.debug("Enter Course Duration");
			int courseDurationInMonths = sc.nextInt();
			LOGGER.debug("Enter no of topics");
			int t = sc.nextInt();
			sc.nextLine();
			LOGGER.debug("Enter topics");
			List<String> topics = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				String s = sc.nextLine();
				topics.add(s);
			}
			List<AssignmentsDTO> ass=new ArrayList<>();
			return new CourseDTO(courseName, courseId, courseDescription, courseDurationInMonths, topics,ass);
		
		

		

	}

}
