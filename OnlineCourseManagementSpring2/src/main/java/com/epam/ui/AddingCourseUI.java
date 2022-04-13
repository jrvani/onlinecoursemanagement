package com.epam.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;
import com.epam.utility.ScannerUtil;



@Component
public class AddingCourseUI {
	
	private static final Logger LOGGER=LogManager.getLogger(AddingCourseUI.class);
	@Autowired
	private CourseDTO courseDTO;
	public CourseDTO addCourse() throws InputMismatchException{
		
		Scanner sc =ScannerUtil.getScanner();
		
			LOGGER.info("Enter Course Name");
			String courseName = sc.next();
			LOGGER.info("Enter Course Description");
			sc.nextLine();
			String courseDescription = sc.nextLine();
			LOGGER.info("Enter Course Duration");
			int courseDurationInMonths = sc.nextInt();
		
		
			
			List<AssignmentsDTO> ass=new ArrayList<>();
			//courseDTO =new CourseDTO(courseName, courseDescription, courseDurationInMonths,ass);
			courseDTO.setCourseName(courseName);
			courseDTO.setCourseDescription(courseDescription);
			courseDTO.setCourseDurationInMonths(courseDurationInMonths);
			courseDTO.setAssignments(ass);
		
		return courseDTO;
		

	}

}
