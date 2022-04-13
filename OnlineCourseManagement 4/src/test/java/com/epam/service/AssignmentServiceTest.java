package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;

 class AssignmentServiceTest {

	private List<CourseDTO> course;
	private List<AssignmentsDTO> assignment;
	List<String> questions;
	AssignmentService assignmentService;

	@BeforeEach
	public void setup() {
		course = new ArrayList<>();
		assignment = new ArrayList<>();
		questions = new ArrayList<>();
		
		course.add(new CourseDTO("java", "1234", "java oops ", 6, Arrays.asList("1.oops", " 2.polymorphism"), assignment));
		assignment.add(new AssignmentsDTO("java 1", "ass1", "22 12 2019", 25, questions));
	    assignmentService = new AssignmentService(
				new InstructorDTO("jrvani", "vani123@gamil.com", "vani", "pass", course), "Java");
	}

	@Test
	void addAssignmentTest() {
		questions.add("who r u");
		questions.add("where r u");

		
		try {
			assignmentService.addAssignments("java 2", "ass2", "22 12 2019", 25, questions);
		} catch (CourseNotExists e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = assignmentService.getSize();
		assertEquals(2, result);

	}

	@Test
	void addNullAssignmentTest() {
		questions.add("who r u");
		questions.add("where r u");

		assignmentService = new AssignmentService(
				new InstructorDTO("jrvani", "vani123@gamil.com", "vani", "pass", course), null);
		assertThrows(CourseNotExists.class, () -> {
			assignmentService.addAssignments("java 1", "ass1", "22 12 2019", 25, questions);
		});

	}

	@Test
	void viewAssignmentTest() {
		
		assignment.add(new AssignmentsDTO("java 3", "ass1", "22 12 2019", 25, questions));
		assignment.add(new AssignmentsDTO("java 4", "ass2", "22 12 2019", 25, questions));
		assignmentService.viewAssignments();
		int result = assignmentService.getSize();
		assertEquals(3, result);
	}
	


	@Test
	void deleteFalseTest() throws CourseNotExists {
		
		boolean b = assignmentService.deleteAssignments("oops");
		assertEquals(false, b);
	}

	@Test
	void deleteTrueTest() {
		

		boolean b = assignmentService.deleteAssignments("java 1");
		assertEquals(true, b);
	}

}
