package com.epam.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.dto.CourseDTO;
import com.epam.entity.Course;
import com.epam.model_mapper.ModelMapperService;
import com.epam.service.CourseService;
import com.epam.utility.ScannerUtil;

@Component
public class CourseUI {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private AssignmentUI assignments;
	
	
	
	
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	private static final Logger LOGGER = LogManager.getLogger(CourseUI.class);
    
	public void courseMenu(int id) {

		int n = 1;
		Scanner sc=ScannerUtil.getScanner();
	
		try {
		do {
			LOGGER.info("Enter your choice \n 1.creating course \n 2.deleting course \n 3.view course \n 4.Log out ");
			
			n = sc.nextInt();
            
			switch (n) {
			case 1:
				
				CourseDTO c = inputException();
				Course course=ModelMapperService.convertDtoToCourseEntity(c);
				System.out.println(course);
				courseService.addCourse(id,course);
				
				LOGGER.info("Want to continue with assignments of the course Enter yes/no");
				sc.nextLine();
				String b = sc.next();
			   
				if (b.equals("yes")) {
					
					
					assignments.assignmentMenu(id, course.getCourseName());
				}

				break;
			case 2:
				sc.nextLine();
				LOGGER.info("Enter course name to delete");
				String courseName = sc.nextLine();
				courseService.deleteCourse(id,courseName);
				
				break;
			case 3:
				List<CourseDTO> list=courseService.viewCourse(id);
				LOGGER.info("Courses");
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



	private CourseDTO inputException() {
		
		AddingCourseUI add = new AddingCourseUI();
		return add.addCourse();
		
		
	}

}
