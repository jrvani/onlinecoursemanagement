package com.epam.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;
import com.epam.utility.ScannerUtil;




public class AddingCourseUI {
	
	private static final Logger LOGGER=LogManager.getLogger(AddingCourseUI.class);
	CourseDTO courseDTO;
	public CourseDTO addCourse(){
		
		Scanner sc =ScannerUtil.getScanner();
		
			LOGGER.info("Enter Course Name");
			String courseName = sc.nextLine();
			LOGGER.info("Enter Course Description");
			
			String courseDescription = sc.nextLine();
			LOGGER.info("Enter Course Duration");
			int courseDurationInMonths = sc.nextInt();
		
		
			
			List<AssignmentsDTO> ass=new ArrayList<>();
			courseDTO =new CourseDTO(courseName, courseDescription, courseDurationInMonths,ass);
			
		
		return courseDTO;
		

	}

}
