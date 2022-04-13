package com.epam.ui;
import java.util.*;

import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.dao.InstructorDAO;
import com.epam.database.CourseDB;


public class Registration {
	public Registration()
	{
		
	}
	
	public boolean register()
	{
		boolean registerFlag=false;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name: ");
    	String name=sc.nextLine();
    	System.out.println("Enter your email: ");
    	String email=sc.next();
    	System.out.println("Enter your username: ");
    	String username=sc.next();
    	System.out.println("Enter your password: ");
        String password=sc.next();
        List<CourseDTO> userCourse=CourseDB.courses;
		InstructorDTO instructorDTO=new InstructorDTO(name,email,username,password,userCourse);
		InstructorDAO instructorDao=new InstructorDAO();
        List<InstructorDTO> list=instructorDao.getInstructors();
		//List<InstructorDTO> list=Database.instructors;
		list.add(instructorDTO);
		registerFlag=true;
		return registerFlag;
		/*List<InstructorDTO> inslist=Database.instructors;
        for(InstructorDTO instDTO:inslist)
        {
        	System.out.println(instDTO);
        }*/
		
	}

}
