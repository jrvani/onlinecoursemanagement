package com.epam.ui;

import com.epam.dto.*;
import java.util.*;
import com.epam.service.*;
import com.epam.dto.InstructorDTO;

public class InstructorUI {

	public void menu(String username, InstructorDTO instructor) {

		int n=1;
		Scanner sc = new Scanner(System.in);
		CourseService course = new CourseService(username, instructor);
		do {
			System.out.println("Enter your choice \n 1.creating course \n 2.deleting course \n 3.view course \n 4.Assignments \n 5.Log out");
			
			n = sc.nextInt();
			switch (n) {
			case 1:
				AddingCourseUI addCourse=new AddingCourseUI();
				System.out.println(instructor);
				CourseDTO c = addCourse.addCourse(instructor);
				course.addCourse(c);
				break;
			case 2:
				String courseName = sc.next();
				course.deleteCourse(courseName);
				break;
			case 3:
				course.viewCourse();
				break;
			case 4:
				System.out.println("Enter course name to go through Assignment");

				courseName = sc.next();
				AssignmentUI assignments = new AssignmentUI();
				assignments.assignmentMenu(instructor, courseName);
				break;

			case 5:
				System.out.println("logging out");
				break;
			default:
				System.out.println("no valid option");

			}
		} while (n < 5);
		sc.close();

	}
}
