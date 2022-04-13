package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.dao.AssignmentDAOInterface;
import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.entity.Instructor;
@ExtendWith(MockitoExtension.class)
class AssignmentTest {
	
	@Mock
	AssignmentDAOInterface assignmentDAO;
	
	@Captor
	ArgumentCaptor<Integer> argumentCaptorForAss;
	Assignment assignment1;
	Assignment assignment2;
	Course course1;
	Instructor i;
	List<Course> courselist=new ArrayList<>();
	List<Assignment> asslist=new ArrayList<>();
	@BeforeEach
	void setup()
	{
		
		 i=new Instructor();
		i.setName("vani");
		i.setUsername("vani16");
		i.setPassword("vani");
		i.setInstructorId(1);
		
		course1=new Course();
		 course1.setCourseName("java");
		 course1.setCourseId(1);
		 course1.setCourseDurationInMonths(2);
		 course1.setCourseDescription("all about java");
		 course1.setInstructor(i);
		 courselist.add(course1);
		 
		 assignment1=new Assignment();
		 assignment1.setAssignmentName("java 1");
		 assignment1.setCourse(course1);
		 assignment1.setAssignmentId(1);
		 
		 assignment2=new Assignment();
		 assignment2.setAssignmentName("java 2");
		 assignment2.setCourse(course1);
		 assignment2.setAssignmentId(2);
		 
		 asslist.add(assignment2);
		 asslist.add(assignment1);
		 course1.setAssignments(asslist);
		 
	}
	@Test
	void getCourseTest() {
		
		
		doAnswer(invocation->{
			int id=invocation.getArgument(0);
			String string=invocation.getArgument(1);
			List<Course> coursesList=courselist.stream().filter(c->c.getInstructor().getInstructorId()==id && c.getCourseName().equals(string)).collect(Collectors.toList());
			return coursesList.get(0);
		}).when(assignmentDAO).getCourse(anyInt(),anyString());
		
		AssignmentService ass=new AssignmentService(assignmentDAO);
		assertEquals("java", ass.getCourses(1, "java").getCourseName());
	}
	@Test
	void getNullCourse()
	{
		when(assignmentDAO.getCourse(1, "course1")).thenReturn(null);
		AssignmentService ass=new AssignmentService(assignmentDAO);
		assertEquals(null, ass.getCourses(1, "course1"));
	}
	@Test
	void addAssignmentTest()
	{
		
		 
		 when(assignmentDAO.add(assignment1)).thenReturn(assignment1);
		 AssignmentService ass=new AssignmentService(assignmentDAO);
		 assertEquals("java 1", ass.addAssignments(course1, assignment1).getAssignmentName());
		 
	}
	
	@Test
	void viewTest()
	{
		
		 when(assignmentDAO.view(course1)).thenReturn(course1.getAssignments());
		 AssignmentService ass=new AssignmentService(assignmentDAO);
		 List<Assignment> l=ass.viewAssignments(course1);
		 assertEquals(2,l.size());
		 
	}
	
	@Test
	void deleteTest()
	{
		int id=assignment1.getAssignmentId();
		doNothing().when(assignmentDAO).delete(id);
		AssignmentService ass=new AssignmentService(assignmentDAO);
		ass.deleteAssignments(course1, "java 1");
		verify(assignmentDAO,times(1)).delete(argumentCaptorForAss.capture());
		assertEquals(1,argumentCaptorForAss.getValue());
	}

}
