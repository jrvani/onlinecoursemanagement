package com.epam.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
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

import javax.servlet.http.HttpSession;

import org.assertj.core.error.ShouldHaveSameSizeAs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.entity.Course;
import com.epam.entity.Instructor;
import com.epam.service.CourseService;
@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	CourseService courseService;

	/*@Mock
	HttpSession session;*/
	
	List<CourseDTO> courseV;
	
	@BeforeEach
	void setup() throws Exception
	{
		InstructorDTO i=new InstructorDTO();
		i.setName("vani");
		i.setInstructorId(4);
	    courseV=new ArrayList<>();
		courseV.add(new CourseDTO("java","all about java", 2, new ArrayList<>()));
		courseV.add(new CourseDTO("sql","all about sql", 5, new ArrayList<>()));
		i.setCourseList(courseV);
		
	}

	@Test
	void loadCoursestest() throws Exception {
		HashMap<String, Object> session= new HashMap<String, Object>();
		session.put("id",2);
		when(courseService.viewAllCourse(2)).thenReturn(courseV);
		mockMvc.perform(get("/loadCourses").sessionAttrs(session))
		.andExpect(model().attribute("courseV",hasSize(2))).andExpect(view().name("courses"));
		
		assertEquals(2, courseV.size());
		
	}
	
	@Test
	void loadAddCourseTest() throws Exception
	{
		mockMvc.perform(get("/loadAddCourse")).andExpect(view().name("addCourse")).andExpect(model().attributeExists("courseDTO"));
	}
	
	@Test
	void addTest() throws  Exception //due to binding
	{
		HashMap<String, Object> session= new HashMap<String, Object>();
		session.put("id",1);
		doNothing().when(courseService).addCourse(1, new Course());
		mockMvc.perform(post("/add").sessionAttrs(session).sessionAttr("courseDTO",CourseDTO.class)).andExpect(view().name("addCourse"));
		//verify(courseService,times(1)).addCourse(1, new Course());
	}
	
	@Test
	void viewTest() throws Exception
	{
		String cid="1";
		CourseDTO c=new CourseDTO("java","jdbc", 5, new ArrayList<>());
		c.setCourseId(1);
		when(courseService.viewCourse(1)).thenReturn(c);
		mockMvc.perform(get("/view").param("cid",cid)).andExpect(view().name("view"));
		assertEquals("java",courseService.viewCourse(1).getCourseName());
		
		
	}
	
	@Test
	void deleteTest() throws Exception
	{
		String cname="java";
		HashMap<String, Object> session= new HashMap<String, Object>();
		session.put("id",1);
		doNothing().when(courseService).deleteCourse(1, cname);
		mockMvc.perform(get("/loaddelete").param("cname",cname).sessionAttrs(session)).andExpect(view().name("redirect:/loadCourses"));
		verify(courseService,times(1)).deleteCourse(1, cname);
	}

}
