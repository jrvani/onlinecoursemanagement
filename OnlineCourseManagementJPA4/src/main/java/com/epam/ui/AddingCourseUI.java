package com.epam.ui;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;
import com.epam.utility.ScannerUtil;




public class AddingCourseUI {
	private static final Logger LOGGER=LogManager.getLogger(AddingCourseUI.class);
	public CourseDTO addCourse() {
		Scanner sc =ScannerUtil.getScanner();
			LOGGER.debug("Enter Course Name");
			String courseName = sc.next();
			LOGGER.debug("Enter Course Description");
			sc.nextLine();
			String courseDescription = sc.nextLine();
			LOGGER.debug("Enter Course Duration");
			int courseDurationInMonths = sc.nextInt();
			
			List<AssignmentsDTO> ass=new ArrayList<>();
			return new CourseDTO(courseName, courseDescription, courseDurationInMonths,ass);
		
		

		

	}

}
