
package com.epam.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.QuestionDTO;
import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.model_mapper.ModelMapperService;
import com.epam.service.AssignmentService;
import com.epam.utility.ScannerUtil;

@Component
public class AssignmentUI {
	private static final Logger LOGGER = LogManager.getLogger(AssignmentUI.class);
    @Autowired
    private AssignmentService assignmentService;
    
    @Autowired
    private QuestionUI  questionUI;
    
   
   
	public void assignmentMenu(int id, String courseName) {
		
		Scanner sc = ScannerUtil.getScanner();
	
		int n = 0;
       
		Course c=assignmentService.getCourses(id, courseName);
       
	
		while(n<5) {
			LOGGER.info(
					"Choose options \n 1.Add Assignments \n 2.view Assignments \n 3.Delete Assignments \n 4.Questions \n 5.LogOut");

			n = sc.nextInt();
			sc.nextLine();
			switch (n) {
			
			case 1:
				LOGGER.info("Enter Assignment Name");
				String assignmentName = sc.nextLine();
			
				LOGGER.info("Enter Assignment date");
				
				String date = sc.nextLine();
				LOGGER.info("Enter Assignment score");
				int score = sc.nextInt();
				List<QuestionDTO> list=new ArrayList<QuestionDTO>();
				AssignmentsDTO assignmentDto=new AssignmentsDTO(assignmentName, date, score,list);
			    System.out.println(assignmentDto);
				Assignment assignment=ModelMapperService.convertDtoToAssignmentEntity(assignmentDto);
				System.out.println(assignment);
				assignmentService.addAssignments(c,assignment);
				
				break;
			case 2:
				List<AssignmentsDTO> list1=assignmentService.viewAssignments( c);
				LOGGER.info("Assignments");
				for(AssignmentsDTO a:list1)
				{
					LOGGER.info(a);}
				break;
			case 3:
				LOGGER.info("Enter assignment name to delete");
				assignmentName = sc.nextLine();
			
				assignmentService.deleteAssignments(c,assignmentName);
					
				break;
			case 4:
				LOGGER.info("Enter assignment name to for accessing questions");
				assignmentName = sc.nextLine();
				
			    
			    questionUI.questionMenu(assignmentName);
			    break;
				
			case 5:
				LOGGER.info("logged out");
				break;
			default:
				LOGGER.info("Invalid options");
			}
		}

	}


	

}
