package com.epam.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.dao.QuestionDAOInterface;
import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.entity.Instructor;
import com.epam.entity.Question;
import com.epam.exceptions.AssignmentNotFound;
@ExtendWith(MockitoExtension.class)
class QuestionTest {
	@Mock
	QuestionDAOInterface questionDAO;
	Assignment assignment1;
	Course course1;
	Instructor i;
	List<Course> courselist=new ArrayList<>();
	List<Assignment> asslist=new ArrayList<>();
	List<Question> queslist=new ArrayList<>();
	Question question1;
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
		 
		 question1=new Question();
		 question1.setQuestionName("what is java");
		 queslist.add(question1);
	}
	
	
	@Test
	void addtest() {
		
		QuestionService service=new QuestionService(questionDAO);
		doNothing().when(questionDAO).add(question1);
		service.add(assignment1, question1);
		verify(questionDAO,times(1)).add(question1);
		
	}
	
	@Test
	void viewTest()
	{
		QuestionService service=new QuestionService(questionDAO);
		when(questionDAO.view(assignment1)).thenReturn(queslist);
		service.view(assignment1);
		verify(questionDAO,times(1)).view(assignment1);
		
		
	}
	
	@Test
	void deleteTest()
	{
		doNothing().when(questionDAO).delete(assignment1, 1);
		QuestionService service=new QuestionService(questionDAO);
		service.deleteQuestion(assignment1, 1);
		verify(questionDAO,times(1)).delete(assignment1, 1);
		
	}
	
	@Test
	void getAssignmentTest() throws AssignmentNotFound
	{
		Assignment ass4=new Assignment();
		ass4.setAssignmentName("cns");
		
		when(questionDAO.getAssignment("cns")).thenReturn(ass4);
		QuestionService service=new QuestionService(questionDAO);
		
		assertEquals("cns", service.getAssignment("cns").getAssignmentName());
		
	}
	
	@Test
	void getNullTest()
	{
		when(questionDAO.getAssignment("cns")).thenReturn(null);
		QuestionService service=new QuestionService(questionDAO);
		assertThrows(AssignmentNotFound.class, ()->{service.getAssignment("cns");});
	}
	

}
