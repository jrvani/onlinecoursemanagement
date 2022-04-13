package com.epam.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.exceptions.CourseNotExists;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerExceptionTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void courseNotExistsTest()
	{
		//mockMvc.perform().andExpect(view().name("/error"));
		
	}

	

}
