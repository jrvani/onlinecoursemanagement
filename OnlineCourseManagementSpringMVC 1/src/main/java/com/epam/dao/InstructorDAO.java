package com.epam.dao;

import java.util.List;

import com.epam.dto.InstructorDTO;
import com.epam.entity.Instructor;

public interface InstructorDAO {
	
	public List<Instructor> getAllInstructor();
	public void save(Instructor instructor);

}
