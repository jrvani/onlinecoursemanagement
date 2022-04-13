package com.epam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.epam.dto.AssignmentsDTO;
import com.epam.entity.Assignment;
import com.epam.entity.Course;

public interface AssignmentDAO extends JpaRepository<Assignment,Integer> {
 
	@Query("select c from Course c where instructor_instructor_id=:id AND course_name=:courseName")
	public Course getCourse(@Param("id") int id,@Param("courseName") String c);

	@Query("select a from Assignment a where course_cid=:id")
	public List<Assignment> findAll(@Param("id") int courseId);

	
	
	

}
