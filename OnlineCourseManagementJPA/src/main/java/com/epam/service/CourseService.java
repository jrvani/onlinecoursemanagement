package com.epam.service;

import java.util.List;

import com.epam.dao.CourseDAOInterface;
import com.epam.dto.CourseDTO;
import com.epam.entity.Course;
import com.epam.exceptions.InstructorNotFound;
import com.epam.model_mapper.ModelMapperService;
public class CourseService {
	
	CourseDAOInterface courseDaoInterface ;
	public CourseService(CourseDAOInterface courseDaoInterface) {

		this.courseDaoInterface = courseDaoInterface;

	}


	public void addCourse(int id,Course course) throws NullPointerException,InstructorNotFound {
		if (course == null) {
			throw new NullPointerException(); //coursenotexists
		}
		if(courseDaoInterface.find(id)==null)
		{
			throw new InstructorNotFound("instructor does not exists");
		}
		course.setInstructor(courseDaoInterface.find(id));
		courseDaoInterface.add(course);
		

	}

	public void deleteCourse(int id, String courseName) {

		courseDaoInterface.delete(id, courseName); //return

	}

	public List<CourseDTO> viewCourse(int id) {
		List<Course> list = courseDaoInterface.view(id);
		return ModelMapperService.convertList(list);
	}

}
