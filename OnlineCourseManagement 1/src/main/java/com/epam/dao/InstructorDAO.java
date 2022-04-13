package com.epam.dao;

import com.epam.database.*;
import com.epam.dto.*;
import java.util.*;
//cannot acess the database directly so use dao
public class InstructorDAO {
	public List<InstructorDTO> getInstructors(){
	Database database=new Database();
	List<InstructorDTO> instructorsList=database.getInstructors();
	//List<InstructorDTO> instructorsList=Database.instructors;
	return instructorsList;
	}
	
	
	
	
	

}
