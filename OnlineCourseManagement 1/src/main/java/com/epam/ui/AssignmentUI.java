package com.epam.ui;

import java.util.*;

import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.service.AssignmentService;

public class AssignmentUI {
	public void assignmentMenu(InstructorDTO instructor, String courseName) {
		CourseDTO courseDTO = null;
		
		List<CourseDTO> list = instructor.getCourseList();
		for (CourseDTO t : list) {
			if (t.getCourseName().equals(courseName)) {
				courseDTO = t;
				break;
			}
		}

		System.out.println(courseDTO);
		AssignmentService assignments = new AssignmentService(courseDTO);
		int n = 0;
		do {
			System.out.println(
					"Choose options \n 1.Add Assignments \n 2.view Assignments \n 3.Delete Assignments \n 4.LogOut");
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("Enter Assignment Name");
				String assignmentName = sc.next();
				System.out.println("Enter Assignment id");
				String assignmentId = sc.next();
				sc.nextLine();
				System.out.println("Enter Assignment date");
				String date = sc.nextLine();
				System.out.println("Enter Assignment score");
				int score = sc.nextInt();
				System.out.println("Enter No of Questions");
				int q = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter questions");
				List<String> questions = new ArrayList<String>();
				for (int i = 0; i < q; i++) {
					String ques = sc.nextLine();
					questions.add(ques);
				}

				assignments.addAssignments(assignmentName, assignmentId, date, score, questions);
				break;
			case 2:
				assignments.viewAssignments();
				break;
			case 3:
				assignmentName = sc.next();

				assignments.deleteAssignments(assignmentName);
				break;
			case 4:
				System.out.println("logged out");
				break;
			default:
				System.out.println("Invalid options");
			}
		} while (n < 4);

	}

}
