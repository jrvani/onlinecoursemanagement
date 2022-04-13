package com.epam.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;


public class AssignmentService {
	CourseDTO courseDTO=null;
	private static final Logger LOGGER=LogManager.getLogger(AssignmentService.class);

	public AssignmentService(CourseDTO courseDTO)
	{
		this.courseDTO=courseDTO;
	}
	
	public void addAssignments(String assignmentName,String assignmentId,String date,int score,List<String> questions)
	{
		List<AssignmentsDTO> assignment=courseDTO.getAssignments();
		AssignmentsDTO a=new AssignmentsDTO(assignmentName,assignmentId,date,score,questions);
		assignment.add(a);
		LOGGER.info("Successfully added assignment to {}",courseDTO.getCourseName());
	}
	
	public void viewAssignments()
	{
		List<AssignmentsDTO> assignment=courseDTO.getAssignments();
		LOGGER.info("The list of assignments : ");
		for(AssignmentsDTO a: assignment) {

			LOGGER.info(a);
		}
	}
	
	public void deleteAssignments(String assignmentName)
	{
		List<AssignmentsDTO> assignment=courseDTO.getAssignments();
		boolean flag=assignment.removeIf(a->a.getAssignmentName().equalsIgnoreCase(assignmentName));
		if(flag)
		{
			LOGGER.debug("successfully deleted assignment");
		}else {
			LOGGER.debug("No matching assignment name");
		}
		
	}
	
	

}
