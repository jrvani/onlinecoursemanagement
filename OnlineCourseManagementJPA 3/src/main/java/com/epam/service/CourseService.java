package com.epam.service;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;

import com.epam.dao.CourseDAO;
import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.entity.*;

public class CourseService {

	InstructorDTO instructorDto = null;
	Instructor instructor=null;
	private static final Logger LOGGER = LogManager.getLogger(CourseService.class);
	CourseDAO courseDAO=new CourseDAO();
	int id;
	public CourseService() {
	}
	public CourseService(InstructorDTO instructorDto) {

		this.instructorDto = instructorDto;
		instructor=convertDtoToInsEntity(instructorDto);
		System.out.println(instructor);
		id=instructor.getInstructorId();
		System.out.println("id "+id);
	

	}

	public void addCourse(CourseDTO courseDto) {
		
		Course course=convertDtoToCourseEntity(courseDto);
		course.setInstructor(instructor);
	    courseDAO.add(course);
	    
		//LOGGER.info("successfully added");
		

	}

	public void deleteCourse(String courseName) {
		courseDAO.delete(id,courseName); 
		
	}
    
	public List<CourseDTO> viewCourse() {
		List<Course> list=courseDAO.view(id);
		return convertList(list);
	}
	
	public Instructor convertDtoToInsEntity(InstructorDTO instructorDto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(instructorDto,Instructor.class);
	}
	
	public Course convertDtoToCourseEntity(CourseDTO courseDto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(courseDto,Course.class);
	}
	
	public List<CourseDTO> convertList(List<Course> list)
	{
		ModelMapper mapper=new ModelMapper();
		return list.stream().map(i->mapper.map(i,CourseDTO.class)).collect(Collectors.toList());
	
	}

}
