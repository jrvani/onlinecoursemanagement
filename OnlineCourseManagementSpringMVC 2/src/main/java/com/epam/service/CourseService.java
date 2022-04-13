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
	
	

	public CourseService(CourseDAO courseDaoInterface) {
     
		this.courseDaoInterface = courseDaoInterface;

	}


	public void addCourse(int id,Course course) throws CourseNotExists {
		
		if (course.getCourseName().isEmpty()) {
			throw new CourseNotExists("course not exists");
		}
		
		
		course.setInstructor(courseDaoInterface.find(id));
		courseDaoInterface.add(course);
		

	}

	public void deleteCourse(int id, String courseName) {

		courseDaoInterface.delete(id, courseName);

	}
    public CourseDTO viewCourse(int cid)
    {
    	Course c=courseDaoInterface.findCourse(cid);
    	return ModelMapperService.convertCourseEntityToDTO(c);
    }
	public List<CourseDTO> viewAllCourse(int id) {
	
		List<Course> list = courseDaoInterface.view(id);
		return ModelMapperService.convertList(list);
	}

}
