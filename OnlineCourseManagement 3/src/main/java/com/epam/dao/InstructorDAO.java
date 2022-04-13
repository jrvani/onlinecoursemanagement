package com.epam.dao;

import com.epam.database.*;
import com.epam.dto.*;
import java.util.*;
//cannot access the database directly so use dao
public class InstructorDAO {
	
	public  List<InstructorDTO> getInstructors() {
		return Database.instructors;
	}
	
	
	public List<CourseDTO> getCourses()
	{
		return Database.courses;
	}
	
	public List<AssignmentsDTO> getAssignment()
	{
		return Database.assignments;
	}


	
	
	

}
