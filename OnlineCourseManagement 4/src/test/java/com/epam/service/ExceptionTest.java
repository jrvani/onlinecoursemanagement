package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

 class ExceptionTest {
	
	
	@Test
	void emptyFieldException()
	{
		
		Exception exception=assertThrows(EmptyFieldException.class,()->{throw new EmptyFieldException("field is empty");});
		assertEquals("field is empty",exception.getMessage());
	}
	
	@Test
	void courseNotExistsException()
	{
		
		Exception exception=assertThrows(CourseNotExists.class,()->{throw new CourseNotExists("Course does not exists");});
		assertEquals("Course does not exists",exception.getMessage());
	}

}
