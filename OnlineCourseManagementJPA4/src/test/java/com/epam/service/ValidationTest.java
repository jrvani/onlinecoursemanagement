package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.dao.InstructorDAOInterface;
import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.entity.Instructor;
import com.epam.exceptions.EmptyFieldException;
@ExtendWith(MockitoExtension.class)

class ValidationTest {
    
	@Mock
	 InstructorDAOInterface instructorDao;
	Instructor i;
	Instructor j;
	List<Instructor> instructorlist=new ArrayList<>();
	@BeforeEach
	void setup()
	{
		 i=new Instructor();
		i.setName("vani");
		i.setUsername("vani16");
		i.setInstructorId(4);
		i.setPassword("vani");
		 j=new Instructor();
		j.setName("sush");
		j.setUsername("sush12");
		j.setPassword("sush");
		
		instructorlist.add(i);
		instructorlist.add(j);
		
		
	}
	@Test
	void getAllInstructorsTest() {
	
		when(instructorDao.getAllInstructor()).thenReturn(instructorlist);
	
		Validation validation=new Validation(instructorDao);
		
		assertEquals(2, validation.getInstructors().size());
	}
    
	@Test
	void addInstructorTest()
	{
	
		
		List<CourseDTO> list=new ArrayList<>();
		InstructorDTO instructorDTO=new InstructorDTO("paru","paru12","paru",list);
		instructorDTO.setInstructorId(1);
		
		when(instructorDao.getAllInstructor()).thenReturn(instructorlist);
		doNothing().when(instructorDao).save(instructorDTO);
		Validation validation=new Validation(instructorDao);
		
		
		assertEquals(true, validation.register(instructorDTO));
		
		
		
	}
	@Test
	void addInstructorUnsucessfullTest()
	{

		
		List<CourseDTO> list=new ArrayList<>();
		InstructorDTO instructorDTO=new InstructorDTO("vani","vani16","paru",list);
		instructorDTO.setInstructorId(1);
		
		when(instructorDao.getAllInstructor()).thenReturn(instructorlist);
		Validation validation=new Validation(instructorDao);
		
		
		assertEquals(false, validation.register(instructorDTO));
		
		
		
	}
	
	@Test
	void nullInstructor()
	{
		Validation validation=new Validation(instructorDao);
		assertThrows(NullPointerException.class, ()->{validation.register(null);});
	}
	
	@Test
	void emptyVerify()
	{
		Validation validation=new Validation(instructorDao);
		assertThrows(EmptyFieldException.class, ()->{validation.verifyUser("", "");});
	}
	
	@Test
	void verifiedUser() throws EmptyFieldException
	{
	
		when(instructorDao.getAllInstructor()).thenReturn(instructorlist);
		Validation validation=new Validation(instructorDao);
		
			assertEquals(4, validation.verifyUser("vani16","vani"));
		
	}
	
	@Test
	void notVerifiedUser() throws EmptyFieldException
	{
		
		when(instructorDao.getAllInstructor()).thenReturn(instructorlist);
		Validation validation=new Validation(instructorDao);
		
			assertEquals(0, validation.verifyUser("paru","vani"));
		
	}
}
