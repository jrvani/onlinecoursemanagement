package com.epam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.AssignmentDAO;
import com.epam.dto.AssignmentsDTO;
import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.model_mapper.ModelMapperService;
@Service
public class AssignmentService {
	
	
	
	@Autowired
	private AssignmentDAO assignmentDAOInterface;
	
	public AssignmentService(AssignmentDAO assignmentDAOInterface)
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
   
	public List<AssignmentsDTO> viewAssignments(Course c) {
		List<Assignment> list= assignmentDAOInterface.view(c);
		return ModelMapperService.convertAssignmentList(list);
	
		
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
