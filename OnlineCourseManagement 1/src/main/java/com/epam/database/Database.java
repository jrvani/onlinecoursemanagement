package com.epam.database;


import com.epam.dto.*;
import java.util.*;

public class Database {

	 static List<InstructorDTO> instructors = new ArrayList<InstructorDTO>();
	
	 static List<CourseDTO> courses = CourseDB.courses;
	static {
		instructors.add(new InstructorDTO("jrvani", "vani123@gamil.com", "vani", "pass", courses));
		instructors.add(new InstructorDTO("G Sushma", "sush12@gmail.com", "sush", "sush", courses));

	}
	public List<InstructorDTO> getInstructors(){
	//List<InstructorDTO> instructorsList=database.getInstructors();
	//List<InstructorDTO> instructorsList=Database.instructors;
	return instructors;
	}

	

}
