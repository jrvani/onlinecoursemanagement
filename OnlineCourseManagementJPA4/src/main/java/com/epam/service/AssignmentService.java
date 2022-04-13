package com.epam.service;

import java.util.List;

import com.epam.dao.AssignmentDAOInterface;
import com.epam.entity.Assignment;
import com.epam.entity.Course;

public class AssignmentService {
	
	
	
	AssignmentDAOInterface assignmentDAOInterface;
	public AssignmentService(AssignmentDAOInterface assignmentDAOInterface)
	{
		this.assignmentDAOInterface=assignmentDAOInterface;
	}
	
    
	public Course getCourses(int id,String courseName)
	{
		return assignmentDAOInterface.getCourse(id,courseName);
	    
	}
	public Assignment addAssignments(Course c,Assignment assignment)
	{
		
		assignment.setCourse(c);
		
		return assignmentDAOInterface.add(assignment);
	}
   
	public List<Assignment> viewAssignments(Course c) {
		List<Assignment> list =assignmentDAOInterface.view(c);
		return list;
		
	}

	public void deleteAssignments(Course c,String assignmentName) {
		List<Assignment> list=c.getAssignments();
		for(Assignment a:list)
		{
			if(a.getAssignmentName().equals(assignmentName))
			{
				assignmentDAOInterface.delete(a);
			}
		}
		

	}
	

}
