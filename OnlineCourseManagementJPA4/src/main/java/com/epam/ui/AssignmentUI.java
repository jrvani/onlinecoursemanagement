
package com.epam.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dao.AssignmentDAO;
import com.epam.dao.AssignmentDAOInterface;
import com.epam.dto.AssignmentsDTO;
import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.service.AssignmentService;
import com.epam.model_mapper.*;
import com.epam.utility.ScannerUtil;


public class AssignmentUI {
	private static final Logger LOGGER = LogManager.getLogger(AssignmentUI.class);
    
	public void assignmentMenu(int id, String courseName) {
		
		Scanner sc = ScannerUtil.getScanner();
		AssignmentDAOInterface assignmentDAOInterface=new AssignmentDAO();
		AssignmentService assignmentService = new AssignmentService(assignmentDAOInterface);
  
		int n = 0;

		Course c=assignmentService.getCourses(id, courseName);
		while(n<4) {
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
				AssignmentsDTO assignmentDto=new AssignmentsDTO(assignmentName, date, score);
				Assignment assignment=ModelMapperService.convertDtoToAssignmentEntity(assignmentDto);
				
				assignmentService.addAssignments(c,assignment);
				
				break;
			case 2:
				List<Assignment> list=assignmentService. viewAssignments( c);
				for(Assignment a:list)
				{
					LOGGER.info(a);}
				break;
			case 3:
				LOGGER.debug("Enter assignment name to delete");
				assignmentName = sc.next();
			
				assignmentService.deleteAssignments(c,assignmentName);
					
				break;
			case 4:
				LOGGER.debug("logged out");
				break;
			default:
				LOGGER.debug("Invalid options");
			}
		}

	}

	

}
