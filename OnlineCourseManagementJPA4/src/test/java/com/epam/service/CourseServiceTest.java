package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.dao.CourseDAOInterface;
import com.epam.dto.CourseDTO;
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
	
	@Captor
	private ArgumentCaptor<Course> argumentCaptorForCourse;
	
	Instructor i;
	Course course1;
	List<Course> list=new ArrayList<>();
	@BeforeEach 
	void setUp() throws Exception {
		i=new Instructor();
		i.setInstructorId(1);
		i.setName("vani");
		Instructor j=new Instructor();
		j.setInstructorId(2);
		j.setName("vani");
		course1=new Course();
		 course1.setCourseName("java");
		 course1.setCourseId(1);
		 course1.setCourseDurationInMonths(2);
		 course1.setCourseDescription("all about java");
		 course1.setInstructor(i);
		 Course course2=new Course();
		 course2.setCourseName("java");
		 course2.setCourseId(2);
		 course2.setInstructor(j);
		 course2.setCourseDurationInMonths(2);
		 course2.setCourseDescription("all about java");
		 
		 list.add(course1);
		 list.add(course2);
		

	}

	@AfterEach
	void tearDown() throws Exception {
	} 	
	@Test
	void viewTest()
	{
		
		
		doAnswer(invocation->{
			int id=invocation.getArgument(0);
			return list.stream().filter(c->c.getInstructor().getInstructorId()==id).collect(Collectors.toList());
			
			
		}).when(courseDaoInterface).view(anyInt());
	
		CourseService courseService=new CourseService(courseDaoInterface);
		List<CourseDTO> list2=courseService.viewCourse(1);
		assertEquals(1, list2.size());
	}
	
	@Test
	void addCourseTest() {
		
		
		 
		CourseService courseService=new CourseService(courseDaoInterface);
		
		doNothing().when(courseDaoInterface).add(course1);
		courseService.addCourse(1,course1);
		verify(courseDaoInterface,times(1)).add(argumentCaptorForCourse.capture());
		assertEquals("java",argumentCaptorForCourse.getValue().getCourseName());
		
		
		
		
	}
	
	@Test
	void addNullCourseNoInteractions()
	{
		Course course=new Course();
        CourseService courseService=new CourseService(courseDaoInterface);
		doNothing().when(courseDaoInterface).add(course);
		courseService.addCourse(1,course);
		verify(courseDaoInterface,times(1)).add(course);
	}

	@Test
	void addNullCourse()
	{
		Course course=null;
        CourseService courseService=new CourseService(courseDaoInterface);
		assertThrows(NullPointerException.class,()->{courseService.addCourse(1,course);});
		
	}
	
	@Test
	void delete()
	{
		doNothing().when(courseDaoInterface).delete(anyInt(),anyString());
		CourseService e=new CourseService(courseDaoInterface);
		e.deleteCourse(3,"java");
		verify(courseDaoInterface,times(1)).delete(3,"java");
	}

}
