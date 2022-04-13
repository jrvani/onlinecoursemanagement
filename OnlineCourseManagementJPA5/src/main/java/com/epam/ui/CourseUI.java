package com.epam.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dao.CourseDAO;
import com.epam.dao.CourseDAOInterface;
import com.epam.dto.CourseDTO;
import com.epam.entity.Course;
import com.epam.service.CourseService;
import com.epam.utility.ScannerUtil;
import com.epam.model_mapper.*;
public class CourseUI {
	private static final Logger LOGGER = LogManager.getLogger(CourseUI.class);
    
	public void courseMenu(int id) {

		int n = 1;
		Scanner scn=ScannerUtil.getScanner();
		CourseDAOInterface courseDAOInterface=new CourseDAO();
		CourseService courseService = new CourseService(courseDAOInterface);
		
		try {
		do {
			LOGGER.info("Enter your choice \n 1.creating course \n 2.deleting course \n 3.view course \n 4.Log out ");
			
			n = Integer.parseInt(scn.next());

			switch (n) {
			case 1:
				CourseDTO c;
				try {
				AddingCourseUI add = new AddingCourseUI();
				c = add.addCourse();
				}
				catch(InputMismatchException e)
				{
					throw new InputMismatchException("please type in correct form of input");
				}
				Course course=ModelMapperService.convertDtoToCourseEntity(c);
				courseService.addCourse(id,course);
				
				LOGGER.info("Want to continue with assignments of the course Enter yes/no");
				scn.nextLine();
				String b = scn.next();
			
				if (b.equals("yes")) {
			        try {
					AssignmentUI assignments = new AssignmentUI();
					assignments.assignmentMenu(id, course.getCourseName());
			        }
			        catch(InputMismatchException e)
			        {
			        	throw new InputMismatchException("input not correct");
			        }
				}

				break;
			case 2:
				scn.nextLine();
				LOGGER.info("Enter course name to delete");
				String courseName = scn.nextLine();
				courseService.deleteCourse(id,courseName);
				
				break;
			case 3:
				List<CourseDTO> list=courseService.viewCourse(id);
				for(int i=0;i<list.size();i++)
				{
					LOGGER.info(list.get(i));
				}
				break;
			case 4:
				LOGGER.info("logging out");
				break;
			default:
				LOGGER.info("no valid option");

			}
			
		} while (n < 4);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
        
	}

}
