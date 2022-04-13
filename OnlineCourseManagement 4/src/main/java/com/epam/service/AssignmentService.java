package com.epam.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;

public class AssignmentService {
	CourseDTO courseDTO = null;
	InstructorDTO instructor;
	String courseName;
	List<CourseDTO> list;
	private static final Logger LOGGER = LogManager.getLogger(AssignmentService.class);
	List<AssignmentsDTO> assignment;
	public AssignmentService(InstructorDTO instructor, String courseName) {
		this.instructor = instructor;
		this.courseName = courseName;
		list = instructor.getCourseList();
		this.courseDTO = list.stream().filter(t -> t.getCourseName().equalsIgnoreCase(courseName)).findAny().orElse(null);
	}

	public void addAssignments(String assignmentName, String assignmentId, String date, int score,
			List<String> questions) throws CourseNotExists {
		if (courseDTO == null) {
			throw new CourseNotExists("course not exits");
		}
		assignment = courseDTO.getAssignments();
		AssignmentsDTO a = new AssignmentsDTO(assignmentName, assignmentId, date, score, questions);
		assignment.add(a);
		LOGGER.info("Successfully added assignment to {}", courseDTO.getCourseName());

	}
    public int getSize()
    {
    	assignment = courseDTO.getAssignments();
    	return assignment.size();
    }
	public void viewAssignments() {
		
		 assignment = courseDTO.getAssignments();
		
		LOGGER.info("The list of assignments : ");
		for (AssignmentsDTO a : assignment) {

			LOGGER.info(a);
		}
		
	}

	public boolean deleteAssignments(String assignmentName) {

		 assignment = courseDTO.getAssignments();

		return assignment.removeIf(a -> a.getAssignmentName().equalsIgnoreCase(assignmentName));
		

	}

}
