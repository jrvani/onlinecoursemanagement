package com.epam.service;

import java.util.List;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;

public class AssignmentService {
	CourseDTO courseDTO=null;
	public AssignmentService(CourseDTO courseDTO)
	{
		this.courseDTO=courseDTO;
	}
	
	public void addAssignments(String assignmentName,String assignmentId,String date,int score,List<String> questions)
	{
		List<AssignmentsDTO> assignment=courseDTO.getAssignments();
		AssignmentsDTO a=new AssignmentsDTO(assignmentName,assignmentId,date,score,questions);
		assignment.add(a);
	}
	
	public void viewAssignments()
	{
		List<AssignmentsDTO> assignment=courseDTO.getAssignments();
		System.out.println(assignment);
	}
	
	public void deleteAssignments(String assignmentName)
	{
		List<AssignmentsDTO> assignment=courseDTO.getAssignments();
		for(AssignmentsDTO a: assignment)
		{
			if(a.getAssignmentName().equals(assignmentName))
			{
				assignment.remove(a);
			}
		}
	}
	
	

}
