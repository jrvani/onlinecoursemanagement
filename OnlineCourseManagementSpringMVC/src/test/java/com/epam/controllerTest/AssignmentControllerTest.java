package com.epam.controllerTest;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.Matchers.hasSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.QuestionDTO;
import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.entity.Question;
import com.epam.model_mapper.ModelMapperService;
import com.epam.service.AssignmentService;
import com.epam.service.QuestionService;

@SpringBootTest
@AutoConfigureMockMvc
class AssignmentControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	AssignmentService assignmentService;
	
	@MockBean
	QuestionService questionService;
	
	
	List<Assignment> assignments;
	Course course;
	Assignment assignment;
	@BeforeEach
	void setup()
	{
		assignments=new ArrayList<Assignment>();
		assignments.add(new Assignment("java 1","34 56", 25));
		course=new Course("java","all java",3,assignments);
	}
	
	@Test
	void loadFormTest() throws Exception
	{
		mockMvc.perform(get("/loadAssignment")).andExpect(view().name("assignmentForm"));
	}
	
	@Test
	void getCourseTest() throws Exception
	{
		HashMap<String, Object> session= new HashMap<String, Object>();
		session.put("id",2);
		
		when(assignmentService.getCourses(2, "java")).thenReturn(course);
		mockMvc.perform(post("/getCourse").param("courseName","java").sessionAttrs(session)).andExpect(view().name("redirect:/loadDetails"));
		assertEquals(course, assignmentService.getCourses(2,"java"));
	
	}
	
	


	@Test
	void loadDetailsTest() throws Exception   //need to test this
	{
		List<AssignmentsDTO> assignmentsList=ModelMapperService.convertAssignmentList(assignments);
		when(assignmentService.viewAssignments(course)).thenReturn(assignmentsList);
		System.out.println(assignmentsList.size());
		mockMvc.perform(get("/loadDetails")).andExpect(view().name("assignment")).andExpect(model().attribute("ass",hasSize(0)));
		assertEquals(1,assignmentService.viewAssignments(course).size());
	}
	
	@Test
	void loadAddAssignment() throws Exception
	{
		mockMvc.perform(get("/loadAddAssignment")).andExpect(view().name("addAssignment")).andExpect(model().attributeExists("assignmentsDTO"));
	}
	
	@Test
	void addAssignmentTest() throws Exception  //binding result
	{
		HashMap<String, Object> session= new HashMap<String, Object>();
		session.put("id",2);
		Assignment assignment=new Assignment("java 1","34 56", 25);
		Course course=new Course("java","all java",3,assignments);
		when(assignmentService.addAssignments(course, assignment)).thenReturn(assignment);
		mockMvc.perform(post("/addAssignment").param("assignmentName","java").param("deadline","12 03 2019").param("score","25").sessionAttrs(session))
		       .andExpect(view().name("redirect:/loadDetails"));
	
	}
	
	@Test
	void addAssignmentFailedTest() throws Exception
	{
		HashMap<String, Object> session= new HashMap<String, Object>();
		session.put("id",1);
		AssignmentsDTO assignmentsDTO=new AssignmentsDTO("cns","12 03 2019",25);
		mockMvc.perform(post("/addAssignment").sessionAttr("assignmentsDTO",assignmentsDTO).sessionAttrs(session))
                .andExpect(view().name("addAssignment"));
	}
	
	@Test
	void viewAssigment() throws Exception
	{
		AssignmentsDTO ass=new AssignmentsDTO("cns","12 03 2019",25);
		when(assignmentService.view(2)).thenReturn(ass);
		mockMvc.perform(get("/viewAssignment").param("aid", "2")).andExpect(view().name("redirect:/loadAssQues"));
		assertEquals("cns",assignmentService.view(2).getAssignmentName());
	}
	
	
	@Test
	void loadQuestion() throws Exception  //test
	{
		Assignment assignment=new Assignment("java 1","34 56", 25);
		List<Question> question=new ArrayList<>();
		Question q=new Question();
		q.setQuestionName("what is java");
		q.setQuestionId(1);
		question.add(q);
		when(questionService.view(assignment)).thenReturn(question);
		mockMvc.perform(get("/loadAssQues")).andExpect(view().name("viewAssignment")).andExpect(model().attribute("question",hasSize(0)));
		assertEquals(1, questionService.view(assignment).size());
	}
	
	
	@Test
	public void addQuestion() throws Exception  // binding test
	{
		Assignment assignment=new Assignment("java 1","34 56", 25);
		QuestionDTO questionDto=new QuestionDTO("what is java");
		Question q=new Question();
		q.setQuestionName("what is java");
		q.setQuestionId(1);
		doNothing().when(questionService).add(assignment, q);
		mockMvc.perform(post("/addQuestion").sessionAttr("questionDto", QuestionDTO.class)).andExpect(view().name("redirect:/loadAssQues"));
		//verify(questionService,times(1)).add(assignment, q);
		
	}
	
	@Test
	public void deleteAssignment() throws Exception
	{
		String assname="java";
		doNothing().when(assignmentService).deleteAssignments(course,"java");
		mockMvc.perform(get("/deleteAssignment").param("assname","java")).andExpect(view().name("redirect:/loadDetails"));
		verify(assignmentService,times(1)).deleteAssignments(course,"java");
	}
	
	@Test
	public void deleteQuestion() throws Exception
	{
		
		Assignment assignment=new Assignment("cns","12 03 2019",25);
		assignment.setQuestions(new ArrayList<>());
		doNothing().when(questionService).deleteQuestion(assignment,1 );
		System.out.println("lllll"+assignment);
		mockMvc.perform(get("/deleteQuestion").param("ass","1")).andExpect(view().name("redirect:/loadAssQues"));
		verify(questionService,times(1)).deleteQuestion(assignment,1 );
		
		
	}
	

}
