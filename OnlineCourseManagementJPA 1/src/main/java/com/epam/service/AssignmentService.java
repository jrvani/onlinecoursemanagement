package com.epam.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dao.AssignmentDAO;
import com.epam.entity.*;

public class AssignmentService {
	Instructor instructor;
	String courseName;
	int id;
	int cid;
	Course course=null;
	private static final Logger LOGGER = LogManager.getLogger(AssignmentService.class);
	AssignmentDAO assignmentDAO=new AssignmentDAO();
	
	public AssignmentService(Instructor instructor, String courseName) {
		this.instructor=instructor;
		this.courseName=courseName;
		id=instructor.getInstructorId();
		course=assignmentDAO.getCourse(id,courseName);
	    cid=course.getCourseId();
		
	
	}

	public void addAssignments(Assignment assignment)
	{
		System.out.println("id  "+id+"ass"+assignment);
		
		System.out.println(course);
		
		assignment.setCourse(course);
		assignmentDAO.add(assignment);
	}
   
	public void viewAssignments() {
		List<Assignment> list =assignmentDAO.view(cid);
		LOGGER.info("The list of assignments : ");
		for (Assignment a : list) {

			LOGGER.info(a);
		}
		
	}

	public void deleteAssignments(String assignmentName) {
		assignmentDAO.delete(cid,assignmentName);

	}

}
