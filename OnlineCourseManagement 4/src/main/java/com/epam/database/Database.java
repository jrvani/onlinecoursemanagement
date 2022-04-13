package com.epam.database;


import com.epam.dto.*;
import java.util.*;

public class Database {

	private Database() {
	}
	 public static final List<InstructorDTO> instructors = new ArrayList<>();
	 public static final List<CourseDTO> courses = new ArrayList<>();
	 public static final List<AssignmentsDTO> assignments = new ArrayList<>();
		
			
	static {
		instructors.add(new InstructorDTO("jrvani", "vani123@gamil.com", "vani", "pass", courses));
		instructors.add(new InstructorDTO("G Sushma", "sush12@gmail.com", "sush", "sush", courses));
		courses.add(new CourseDTO("Java", "1234", "java oops ", 6, Arrays.asList("1.oops", " 2.polymorphism"),assignments));

		

	}
	
	
	
	
	

}
