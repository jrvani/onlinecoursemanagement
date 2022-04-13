package com.epam.dao;

import java.util.List;

import com.epam.entity.Instructor;

public interface InstructorDAOInterface {
	
	public List<Instructor> getAllInstructor();
	public void add(Instructor instructor);

}
