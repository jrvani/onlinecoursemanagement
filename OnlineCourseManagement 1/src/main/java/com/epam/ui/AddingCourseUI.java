package com.epam.ui;

import java.util.ArrayList;
import java.util.*;

import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;

public class AddingCourseUI {
	public AddingCourseUI() {

	}

	public CourseDTO addCourse(InstructorDTO instructor) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Name");
		String courseName = sc.next();
		System.out.println("Enter Course Id");
		String courseId = sc.next();
		sc.nextLine();
		System.out.println("Enter Course Description");
		String courseDescription = sc.nextLine();
		System.out.println("Enter Course Duration");
		int courseDurationInMonths = sc.nextInt();
		System.out.println("Enter no of topics");
		int t = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter topics");
		List<String> topics = new ArrayList<String>();
		for (int i = 0; i < t; i++) {
			String s = sc.nextLine();
			topics.add(s);
		}
		CourseDTO courseDTO = new CourseDTO(courseName, courseId, courseDescription, courseDurationInMonths, topics,
				null);
		System.out.println("Want to add assignments to the course Enter yes/no");
		String b = sc.next();
		if (b.equals("yes")) {
			AssignmentUI assignments = new AssignmentUI();
			System.out.println(instructor);
			assignments.assignmentMenu(instructor, courseDTO);
		}

		return courseDTO;

	}

}
