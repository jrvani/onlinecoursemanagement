package com.epam.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.service.Validation;
@SpringBootTest
@AutoConfigureMockMvc
class RegistrationTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	Validation validation;
	
	@MockBean
    private BindingResult bindingResult;
	

	@Test
	void loadRegistrationTest() throws Exception {
		
		
		mockMvc.perform(get("/load")).andExpect(view().name("registration"));
	}
	
	@Test
	void registrationTrueTest() throws Exception
	{
		InstructorDTO instructorDTO=mock(InstructorDTO.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		mockMvc.perform(post("/register").sessionAttr("instructorDto", instructorDTO)).andExpect(view().name("registration"));
	}
	
	@Test
	void registrationTest() throws Exception
	{
		List<CourseDTO> list=new ArrayList<>();
		InstructorDTO instructorDTO=new InstructorDTO("vani","vani","vani",list);
		when(validation.register(instructorDTO)).thenReturn(true); 
		//when(bindingResult.hasErrors()).thenReturn(false);
		mockMvc.perform(post("/register").sessionAttr("instructorDto", instructorDTO)).andExpect(view().name("registration"));
	}
	
	@Test
	void registrationFalseTest() throws Exception
	{
		List<CourseDTO> list=new ArrayList<>();
		BindingResult result = mock(BindingResult.class);
		InstructorDTO instructor=mock(InstructorDTO.class);
		when(validation.register(instructor)).thenReturn(false);  //need to add behavoiur
		mockMvc.perform(post("/register").sessionAttr("instructor", instructor)).andExpect(view().name("registration"));
		assertEquals(false,validation.register(instructor));
	}

}
