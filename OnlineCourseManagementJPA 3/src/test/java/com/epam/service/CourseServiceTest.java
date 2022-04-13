package com.epam.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import com.epam.dao.CourseDAO;
import com.epam.dao.CourseDAOInterface;
import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.entity.Course;
import com.epam.entity.Instructor;


@ExtendWith(MockitoExtension.class)

class CourseServiceTest {
    //test add
	//add null
	//delete course
	//non existing course
	//view
	
	
	@Mock
    CourseDAOInterface courseDaoInterface;
	
	@BeforeEach 
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	} 
	
	@Test
	void viewTest()
	{
		
		Course course=new Course();
		 course.setCourseName("java");
		 course.setCourseId(1);
		 course.setCourseDurationInMonths(2);
		 course.setCourseDescription("all about java");
		 List<Course> list=new ArrayList<>();
		 list.add(course);
		 Instructor instructor=new Instructor();
			instructor.setInstructorId(1);
			instructor.setCourseList(list);
		when(courseDaoInterface.view(1)).thenReturn(list);
		CourseService courseService=new CourseService();
		List<CourseDTO> list2=courseService.viewCourse();
		assertEquals(1, list2);
	}
	
	/*@Test
	void addCourseTest() {
		
		List<AssignmentsDTO> assignments=new ArrayList<>();
	
		CourseDTO courseDTO=new CourseDTO("java ","all about java",2,assignments);
		
		List<CourseDTO> courses=new ArrayList<CourseDTO>();
		courses.add(courseDTO);
		InstructorDTO instructor=new InstructorDTO();
		instructor.setName("vani");
		instructor.setPassword("vani");
		instructor.setUsername("vani16");
		instructor.setCourseList(courses);
		 Course course=new Course();
		 course.setCourseName("java");

		 course.setCourseDurationInMonths(2);
		 course.setCourseDescription("all about java");
		 
		CourseService courseService=new CourseService();
		
		doNothing().when(courseDAO).add(course);
		courseService.addCourse(courseDTO);
		verify(courseDAO,times(1)).add(course);
		
		
		
		
	}*/
	
	/*@Test
	void addNullCourse()
	{
		
	}
	
	@Test
	void delete()
	{
		doNothing().when(courseDAO).delete(3,"java");
		CourseService e=new CourseService();
		e.deleteCourse("java");
		verify(courseDAO).delete(3,"java");
	}*/

}
