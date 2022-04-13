package com.epam.dao;

import com.epam.database.*;
import com.epam.dto.*;
import java.util.*;
//cannot access the database directly so use dao
public class InstructorDAO {
	public List<InstructorDTO> getInstructors(){
	Database database=new Database();
	List<InstructorDTO> instructorsList=database.getInstructors();
	return instructorsList;
	}
	
	
	
	
	

}
