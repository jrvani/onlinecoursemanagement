package com.epam.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.CourseDAO;
import com.epam.dto.CourseDTO;
import com.epam.entity.Course;
import com.epam.exceptions.CourseNotExists;
import com.epam.exceptions.InstructorNotFound;
import com.epam.model_mapper.ModelMapperService;

@Service
public class CourseService {
	@Autowired
    private CourseDAO courseDaoInterface ;
	


	public void addCourse(int id,Course course) throws CourseNotExists {
		
		if (course.getCourseName().isBlank()) {
			throw new CourseNotExists("course not exists");
		}
		
		
		course.setInstructor(courseDaoInterface.getInstructorById(id));
		courseDaoInterface.save(course);
		

	}

	public void deleteCourse(int cid) {

		courseDaoInterface.deleteById(cid);

	}
    public CourseDTO viewCourse(int cid)
    {
    	Course c=courseDaoInterface.getById(cid);
    	return ModelMapperService.convertCourseEntityToDTO(c);
    }
	public List<CourseDTO> viewAllCourse(int id) {
	
		List<Course> list = courseDaoInterface.find(id);
		return ModelMapperService.convertList(list);
	}

}
