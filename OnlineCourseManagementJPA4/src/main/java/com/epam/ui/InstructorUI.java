package com.epam.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.utility.ScannerUtil;


public class InstructorUI {
	private static final Logger LOGGER=LogManager.getLogger(InstructorUI.class);
	public void menu(int id) {

		int n=1;
		Scanner sc;
			do {
				 sc = ScannerUtil.getScanner();
				LOGGER.debug("Enter your choice \n 1.Course Menu \n 2.Assignment Menu \n 3.Log out");
				
				n = sc.nextInt();
				
				switch (n) {
				case 1:
					CourseUI courseUI=new CourseUI();
					courseUI.courseMenu( id);
					
					break;
				case 2:
					AssignmentUI assignmentUI=new AssignmentUI();
					LOGGER.debug("Enter course name to go through Assignment");
			        String courseName = sc.next();
					assignmentUI.assignmentMenu(id, courseName);
					break;
					
				case 3:
					LOGGER.debug("logging out");
					
					break;
				default:
					LOGGER.debug("no valid option");

				}
				
			} while (n < 3);
		
			
       
	}
}
