package com.epam.ui;
import java.util.*;

import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.service.Validation;




public class Registration {
	
	
	public boolean register()
	{
		boolean registerFlag=true;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name: ");
    	String name=sc.nextLine();
    	System.out.println("Enter your email: ");
    	String email=sc.next();
    	System.out.println("Enter your username: ");
    	String username=sc.next();
    	System.out.println("Enter your password: ");
        String password=sc.next();
        List<CourseDTO> userCourse=new ArrayList<>();
        /*try {
        	if(!name.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty())
        	{
        		InstructorDTO instructorDTO=new InstructorDTO(name,email,username,password,userCourse);
        		Validation valid=new Validation();
        		valid.register(instructorDTO);
        		
        	}
        	else
        	{
        		throw new InvalidFieldException("You have one or more fileds as empty");
        	}
        }
        catch()
        {
        	
        }*/
        InstructorDTO instructorDTO=new InstructorDTO(name,email,username,password,userCourse);
		Validation valid=new Validation();
		valid.register(instructorDTO);
		
		return registerFlag;
		
		
	}

}
