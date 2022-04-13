package com.epam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	public AssignmentService()
	{
		
	}
	
    
	public Course getCourses(int id,String courseName)
	{
		
		
			return assignmentDAOInterface.getCourse(id,courseName);
		
	    
	}
	public Assignment addAssignments(Course c,Assignment assignment)
	{
		
		assignment.setCourse(c);
		
		return assignmentDAOInterface.save(assignment);
	}
	public Assignment find(int aid)
	{
		Assignment a=assignmentDAOInterface.findById(aid).orElse(null);
		return a;
	}
   
	public List<AssignmentsDTO> viewAssignments(Course c) {
		List<Assignment> list= assignmentDAOInterface.findAll(c.getCourseId());
		List<AssignmentsDTO> list1= ModelMapperService.convertAssignmentList(list);
		return list1;
	
		
	}

	public void deleteAssignments(int aid) {
		assignmentDAOInterface.deleteById(aid);
		
		
     
	}
	

}
