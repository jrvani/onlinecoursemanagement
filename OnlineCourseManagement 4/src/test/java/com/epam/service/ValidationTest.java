package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;

 class ValidationTest {
	//validations 
		//if new user    //done
		//if old user    //done
		//username password match  //done
		//no match       //done
	
	private  List<CourseDTO> course=new ArrayList<>();;
	
	@Test
	void oldUserRegistration()
	{
		Validation validation=new Validation();
		boolean result=validation.register(new InstructorDTO("jrvani", "vani123@gamil.com", "vani", "pass", course));
		assertEquals(false,result);
	}
	
	@Test
	void nullUserRegistration()
	{
		
		Validation validation=new Validation();
		
		 assertThrows(NullPointerException.class, ()->{validation.register(null);});
		
	}
	
	@Test
	void newUserRegistration()
	{
		Validation validation=new Validation();
		boolean result=validation.register(new InstructorDTO("ram", "vani123@gamil.com", "vani", "pass", course));
		assertEquals(true,result);
	}
	
	@Test
	void loginSuccess()  
	{
		
		Validation validation=new Validation();
		InstructorDTO result = null;
		try {
			result = validation.verifyUser("vani", "pass");
		} catch (EmptyFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("vani",result.getUsername());
		
		
		
	}
	
	
	@Test
	void emptyPasswordLogin()
	{
		
		Validation validation=new Validation();
		
		Exception exception=assertThrows(EmptyFieldException.class,()->{validation.verifyUser("vani", "");});
		assertEquals("username or password is empty",exception.getMessage());
		
	}
	
	@Test
	void emptyUsernameLogin()
	{
		
		Validation validation=new Validation();
		
		assertThrows(EmptyFieldException.class,()->{validation.verifyUser("", "pass");});
		
		
	}
	@Test
	void emptyUsernameAndPasswordLogin()
	{
		
		Validation validation=new Validation();
		
		assertThrows(EmptyFieldException.class,()->{validation.verifyUser("", "");});
		
		
	}
	
	
	@Test
	void loginFail() 
	{
		
		Validation validation=new Validation();
		InstructorDTO result = null;
		try {
			result = validation.verifyUser("raj", "pass");
		} catch (EmptyFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null,result);}
	
	
	}
	
	

