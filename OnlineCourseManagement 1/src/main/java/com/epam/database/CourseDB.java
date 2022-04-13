package com.epam.database;

import com.epam.dto.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//need to add end date of course
public class CourseDB {
	
	public static List<CourseDTO> courses = new ArrayList<CourseDTO>();
	public static List<AssignmentsDTO> assignments = new ArrayList<AssignmentsDTO>();
	static {
		courses.add(new CourseDTO("Java", "1234", "java oops ", 6, Arrays.asList("1.oops", " 2.polymorphism"),assignments));

	}
	
	

}
