package com.epam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.entity.Instructor;

public interface CourseDAO extends JpaRepository<Course, Integer> {

	@Query("Select i from Instructor i WHERE instructorId=:id")
	Instructor getInstructorById(@Param("id") int id);
	
	@Query("select c from Course c where instructor_instructor_id=:id")
	public List<Course> find(@Param("id") int courseId);
	  

}
