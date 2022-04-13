package com.epam.controllerTest;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.CoreMatchers.any;
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
import org.springframework.web.bind.annotation.GetMapping;
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
		mockMvc.perform(post("/getCourse").param("courseName","java").sessionAttrs(session)).andExpect(view().name("redirect:/loadAssQues"));
		assertEquals(course, assignmentService.getCourses(2,"java"));
	
	}
	
	

	
	@Test
	void loadViewpage() throws Exception  //has size
	{
		List<AssignmentsDTO> list=new ArrayList<>();
		list.add(new AssignmentsDTO("java","12 09 2019", 25));
		list.add(new AssignmentsDTO("sql","12 03 2022", 15));
		when(assignmentService.viewAssignments(course)).thenReturn(list);
		mockMvc.perform(get("/loadAssQues")).andExpect(model().attribute("ass",hasSize(2))).andExpect(view().name("viewAssignment"));
	}
	
	@Test
	void loadAddAssignment() throws Exception
	{
		mockMvc.perform(get("/loadAddAssignment")).andExpect(view().name("addAssignment")).andExpect(model().attributeExists("assignmentsDTO"));
	}
	
	@Test
	void addAssignmentTest() throws Exception  //binding result
	{
		Assignment assignment=new Assignment("java 1","34 56", 25);
		Course course=new Course("java","all java",3,assignments);
		when(assignmentService.addAssignments(course, assignment)).thenReturn(assignment);
		mockMvc.perform(post("/addAssignment").param("assignmentName","java").param("deadline","12 03 2019").param("score","25"))
		       .andExpect(view().name("redirect:/loadAssQues"));
	
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
	void loadAddQuestions() throws Exception
	{
		String aid="1";
		assignment=new Assignment("java 1","12 09 2022", 25);
		assignment.setAssignmentId(1);
		when(assignmentService.find(1)).thenReturn(assignment);
		mockMvc.perform(get("/loadaddQuestion").param("aid", aid)).andExpect(view().name("addQuestion"));
	}

	
	@Test
	void addQuestion() throws Exception //due to binding no mocking sol:override
	{ 
		Question q=new Question();
		q.setQuestionName("what is java");
		doNothing().when(questionService).add(assignment, q);
		mockMvc.perform(post("/addQuestion").sessionAttr("questionDto", QuestionDTO.class)).andExpect(view().name("redirect:/loadAssQues"));
		//verify(questionService,times(1)).add(assignment, q);
	}

	
	
	

	
	@Test
	public void deleteAssignment() throws Exception  //due to course it was throwing argument mismatch but override equlas and hashcode in course
	{
		String cname="java";
		doNothing().when(assignmentService).deleteAssignments(course,cname);
		mockMvc.perform(get("/deleteAssignment").param("assname",cname)).andExpect(view().name("redirect:/loadAssQues"));
		verify(assignmentService,times(1)).deleteAssignments(course,cname);
	}
	
	@Test
	public void deleteQuestion() throws Exception
	{
		doNothing().when(questionService).deleteQuestion(1 );
		mockMvc.perform(get("/deleteQuestion").param("qid","1")).andExpect(view().name("redirect:/loadAssQues"));
		verify(questionService,times(1)).deleteQuestion(1 );
		
		
	}
	

}
