package com.epam.ui;

import java.util.ArrayList;
import java.util.*;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;

public class AddingCourseUI {
	
	public CourseDTO addCourse() {
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
		List<String> topics = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			String s = sc.nextLine();
			topics.add(s);
		}
		List<AssignmentsDTO> ass=new ArrayList<>();
		CourseDTO courseDTO = new CourseDTO(courseName, courseId, courseDescription, courseDurationInMonths, topics,ass);
		

		return courseDTO;

	}

}
