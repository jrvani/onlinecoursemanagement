package com.epam.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.service.Validation;
@SpringBootTest 
@AutoConfigureMockMvc

class Login {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	Validation validation;
	

	@Test
	void loadLoginTest() throws Exception
	{
		mockMvc.perform(get("/loadLogin")).andExpect(view().name("login"));
		
	}
	
	@Test
	void loginTest() throws Exception
	{
		String username="vani";
		String password="vani";
		when(validation.verifyUser("vani","vani")).thenReturn(1);
		mockMvc.perform(post("/login").param("username",username).param("password",password)).andExpect(view().name("dashboard"));
		verify(validation,times(1)).verifyUser("vani", "vani");
	}
	
	@Test
	void logoutTest() throws Exception 
	{
		mockMvc.perform(get("/logout")).andExpect(view().name("login"));
	}

}
