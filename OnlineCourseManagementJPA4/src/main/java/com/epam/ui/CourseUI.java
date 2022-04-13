package com.epam.ui;

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
		Scanner sc=ScannerUtil.getScanner();
		CourseDAOInterface courseDAOInterface=new CourseDAO();
		CourseService courseService = new CourseService(courseDAOInterface);
		
		try {
		do {
			LOGGER.debug("Enter your choice \n 1.creating course \n 2.deleting course \n 3.view course \n 4.Log out ");
			
			n = sc.nextInt();

			switch (n) {
			case 1:
				AddingCourseUI add = new AddingCourseUI();
				CourseDTO c = add.addCourse();
				Course course=ModelMapperService.convertDtoToCourseEntity(c);
				courseService.addCourse(id,course);
				LOGGER.info("Want to continue with assignments of the course Enter yes/no");
				String b = sc.next();
			
				if (b.equals("yes")) {
			
					AssignmentUI assignments = new AssignmentUI();
					assignments.assignmentMenu(id, course.getCourseName());
				}

				break;
			case 2:
				LOGGER.debug("Enter course name to delete");
				String courseName = sc.next();
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
