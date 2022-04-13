package com.epam.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;

import com.epam.dao.AssignmentDAO;
import com.epam.dto.AssignmentsDTO;
import com.epam.dto.InstructorDTO;
import com.epam.entity.*;

public class AssignmentService {
	Instructor instructor;
	InstructorDTO instructorDto=null;
	Assignment assignment;
	String courseName;
	int id;
	int cid;
	Course course=null;
	private static final Logger LOGGER = LogManager.getLogger(AssignmentService.class);
	AssignmentDAO assignmentDAO=new AssignmentDAO();
	
	public AssignmentService(InstructorDTO instructorDto, String courseName) {
		this.instructorDto=instructorDto;
		this.courseName=courseName;
		instructor=convertDtoToInsEntity(instructorDto);
		id=instructor.getInstructorId();
		course=assignmentDAO.getCourse(id,courseName);
	    cid=course.getCourseId();
		
	
	}

	public void addAssignments(AssignmentsDTO assignmentDto)
	{
		assignment=convertDtoToAssignmentEntity(assignmentDto);
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
	public Instructor convertDtoToInsEntity(InstructorDTO instructorDto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(instructorDto,Instructor.class);
	}
	
	public Assignment convertDtoToAssignmentEntity(AssignmentsDTO assignmentDto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(assignmentDto,Assignment.class);
	}

}
