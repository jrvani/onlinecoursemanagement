
package com.epam.ui;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.InstructorDTO;

import com.epam.service.*;
import com.epam.utility.ScannerUtil;


public class AssignmentUI {
	private static final Logger LOGGER = LogManager.getLogger(AssignmentUI.class);
    
	public void assignmentMenu(InstructorDTO instructorDto, String courseName) {
		
		Scanner sc = ScannerUtil.getScanner();
		AssignmentService assignments = new AssignmentService(instructorDto,courseName);
		int n = 0;
		do {
			LOGGER.debug(
					"Choose options \n 1.Add Assignments \n 2.view Assignments \n 3.Delete Assignments \n 4.LogOut");

			n = sc.nextInt();
			switch (n) {
			case 1:
				LOGGER.debug("Enter Assignment Name");
				String assignmentName = sc.next();
				LOGGER.debug("Enter Assignment date");
				sc.nextLine();
				String date = sc.nextLine();
				LOGGER.debug("Enter Assignment score");
				int score = sc.nextInt();
				/*LOGGER.debug("Enter No of Questions");
				int q = sc.nextInt();
				sc.nextLine();
				LOGGER.debug("Enter questions");
				List<String> questions = new ArrayList<>();
				for (int i = 0; i < q; i++) {
					String ques = sc.nextLine();
					questions.add(ques);
				}
                */
				AssignmentsDTO assignmentDto=new AssignmentsDTO(assignmentName, date, score);
				assignments.addAssignments(assignmentDto);
				
				break;
			case 2:
				assignments.viewAssignments();
				break;
			case 3:
				LOGGER.debug("Enter assignment name to delete");
				assignmentName = sc.next();
			
				assignments.deleteAssignments(assignmentName);
					
				break;
			case 4:
				LOGGER.debug("logged out");
				break;
			default:
				LOGGER.debug("Invalid options");
			}
		} while (n < 4);

	}

	

}
