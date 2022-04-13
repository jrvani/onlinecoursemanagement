package com.epam.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.entity.*;
import com.epam.service.*;

public class CourseUI {
	private static final Logger LOGGER = LogManager.getLogger(CourseUI.class);
    
	public void courseMenu(Instructor instructor) {

		int n = 1;
		Scanner sc= new Scanner(System.in);
		CourseService course = new CourseService(instructor);
		try {
		do {
			LOGGER.debug("Enter your choice \n 1.creating course \n 2.deleting course \n 3.view course \n 4.Log out ");
			
			n = sc.nextInt();

			switch (n) {
			case 1:
				AddingCourseUI add = new AddingCourseUI();
				Course c = add.addCourse();
				course.addCourse(c);
				LOGGER.info("Want to continue with assignments of the course Enter yes/no");
				String b = sc.next();
				if (b.equals("yes")) {
					AssignmentUI assignments = new AssignmentUI();
					assignments.assignmentMenu(instructor, c.getCourseName());
				}

				break;
			case 2:
				LOGGER.debug("Enter course name to delete");
				String courseName = sc.next();
				course.deleteCourse(courseName);
				
				break;
			case 3:
				course.viewCourse();
				break;
			case 4:
				LOGGER.info("logging out");
				break;
			default:
				LOGGER.debug("no valid option");

			}
			
		} while (n < 4);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
        
	}

}
