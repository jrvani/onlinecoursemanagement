package com.epam.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;

class CourseServiceTest {
	//add a course to instructor //done
	//null courses
	//do not add redundant course to same instructor //done
	//delete course true   //done
	//delete false   //done
    
	
	private List<CourseDTO> course;
	private List<AssignmentsDTO> assignment;
	CourseService courseService;
	@BeforeEach
	public void setup()
	{
		course=new ArrayList<>();
		assignment=new ArrayList<>();
		courseService=new CourseService(new InstructorDTO("jrvani", "vani123@gamil.com", "vani", "pass", course));
		course.add(new CourseDTO("oops", "1234", "java oops ", 6, Arrays.asList("1.oops", " 2.polymorphism"),assignment));
	}
	
	@Test
	void addCourseTest()
	{
		
		courseService.addCourse(new CourseDTO("java", "456", "java oops ", 6, Arrays.asList("1.oops", " 2.polymorphism"),assignment));
		int result=courseService.getSize();
		assertEquals(2,result);
				
	}
	
	@Test
	void addNullCourseTest()
	{
		
		assertThrows(NullPointerException.class,()->{courseService.addCourse(null);});
				
	}
	
	
	@Test
	void addRedundantCourseTest()
	{
		
		courseService.addCourse(new CourseDTO("sql", "124", "java oops ", 6, Arrays.asList("1.oops", " 2.polymorphism"),assignment));
		courseService.addCourse(new CourseDTO("sql", "124", "java oops ", 6, Arrays.asList("1.oops", " 2.polymorphism"),assignment));
		int result=courseService.getSize();
		assertEquals(2,result);
				
	}
	
	@Test
	void addRedundantTest()
	{
		
		courseService.addCourse(new CourseDTO("sql", "124", "java oops ", 6, Arrays.asList("1.oops", " 2.polymorphism"),assignment));
		courseService.addCourse(new CourseDTO("sql", "156", "java oops ", 6, Arrays.asList("1.oops", " 2.polymorphism"),assignment));
		int result=courseService.getSize();
		assertEquals(3,result);
				
	}
	
	
	
	@Test
	void deleteFalseTest()
	{
		
		boolean b=courseService.deleteCourse("java");
		assertEquals(false, b);
	}

	
	@Test
	void deleteTrueTest()
	{
		
		
		boolean b=courseService.deleteCourse("oops");
		assertEquals(true, b);
	}
	
	@Test
	void viewCourseTest()
	{
		courseService.viewCourse();
		int result=courseService.getSize();
		assertEquals(1, result);
	}
	
	
	
	
	
	
	
	

}
