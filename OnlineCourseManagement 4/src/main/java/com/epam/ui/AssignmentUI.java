package com.epam.ui;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.epam.dto.InstructorDTO;
import com.epam.service.AssignmentService;
import com.epam.service.CourseNotExists;

public class AssignmentUI {
	private static final Logger LOGGER = LogManager.getLogger(AssignmentUI.class);
    
	public void assignmentMenu(InstructorDTO instructor, String courseName) {
		
		Scanner sc = new Scanner(System.in);
		try {
			
			AssignmentService assignments = new AssignmentService(instructor,courseName);

			int n = 0;
			do {
				LOGGER.debug(
						"Choose options \n 1.Add Assignments \n 2.view Assignments \n 3.Delete Assignments \n 4.LogOut");

				n = sc.nextInt();
				switch (n) {
				case 1:
					LOGGER.debug("Enter Assignment Name");
					String assignmentName = sc.next();
					LOGGER.debug("Enter Assignment id");
					String assignmentId = sc.next();
					sc.nextLine();
					LOGGER.debug("Enter Assignment date");
					String date = sc.nextLine();
					LOGGER.debug("Enter Assignment score");
					int score = sc.nextInt();
					LOGGER.debug("Enter No of Questions");
					int q = sc.nextInt();
					sc.nextLine();
					LOGGER.debug("Enter questions");
					List<String> questions = new ArrayList<>();
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
					LOGGER.debug("Enter assignment name to delete");
					assignmentName = sc.next();
				
					if (assignments.deleteAssignments(assignmentName)) {
						LOGGER.debug("successfully deleted assignment");
					} else {
						LOGGER.debug("No matching assignment name");
					}
					break;
				case 4:
					LOGGER.debug("logged out");
					break;
				default:
					LOGGER.debug("Invalid options");
				}
			} while (n < 4);

		} catch (CourseNotExists ex) {
			LOGGER.error(ex.getMessage());
		}

	}

	

}
