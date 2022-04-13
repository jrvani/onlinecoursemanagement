package com.epam.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dao.AssignmentDAOInterface;
import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.exceptions.CourseNotExists;

public class AssignmentService {
	
	
	private static final Logger LOGGER = LogManager.getLogger(AssignmentService.class);
	AssignmentDAOInterface assignmentDAOInterface;
	public AssignmentService(AssignmentDAOInterface assignmentDAOInterface)
	{
		this.assignmentDAOInterface=assignmentDAOInterface;
	}
	
    
	public Course getCourses(int id,String courseName)
	{
		try {
			if(assignmentDAOInterface.getCourse(id,courseName)==null)
			{
				throw new CourseNotExists("course not exists");
			}
		}
		catch(CourseNotExists e)
		{
			LOGGER.error(e.getMessage());
		}
		return assignmentDAOInterface.getCourse(id,courseName);
	    
	}
	public Assignment addAssignments(Course c,Assignment assignment)
	{
		
		assignment.setCourse(c);
		
		return assignmentDAOInterface.add(assignment);
	}
   
	public List<Assignment> viewAssignments(Course c) {
		
		return assignmentDAOInterface.view(c);
	
		
	}

	public void deleteAssignments(Course c,String assignmentName) {
		List<Assignment> list=c.getAssignments();
		for(Assignment a:list)
		{
			if(a.getAssignmentName().equals(assignmentName))
			{
				assignmentDAOInterface.delete(a.getAssignmentId());
			}
		}
		

	}
	

}
