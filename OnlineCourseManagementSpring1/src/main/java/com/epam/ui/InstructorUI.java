package com.epam.ui;


import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.utility.ScannerUtil;

@Component
public class InstructorUI {
	
	@Autowired
	CourseUI courseUI;
	
	@Autowired
	AssignmentUI assignmentUI;
	
	
	public CourseUI getCourseUI() {
		return courseUI;
	}
	public void setCourseUI(CourseUI courseUI) {
		this.courseUI = courseUI;
	}
	public AssignmentUI getAssignmentUI() {
		return assignmentUI;
	}
	public void setAssignmentUI(AssignmentUI assignmentUI) {
		this.assignmentUI = assignmentUI;
	}
	
	private static final Logger LOGGER=LogManager.getLogger(InstructorUI.class);
	public void menu(int id) {

		int n=1;
		Scanner sc =ScannerUtil.getScanner();
		
			do {
				
				LOGGER.info("Enter your choice \n 1.Course Menu \n 2.Assignment Menu \n 3.Log out");
				
				n = sc.nextInt();
				
				switch (n) {
				case 1:
				
					courseUI.courseMenu( id);
					
					break;
				case 2:
					
					LOGGER.info("Enter course name to go through Assignment");
					sc.nextLine();
			        String courseName = sc.nextLine();
					assignmentUI.assignmentMenu(id, courseName);
					break;
					
				case 3:
					LOGGER.info("logging out");
					
					break;
				default:
					LOGGER.info("no valid option");

				}
				
			} while (n < 3);
		}
	
	
}
