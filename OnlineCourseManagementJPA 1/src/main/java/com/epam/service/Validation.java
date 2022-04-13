package com.epam.service;

import java.util.List;

import com.epam.dao.InstructorDAO;
import com.epam.entity.*;


public class Validation {
	public boolean register(Instructor instructor) throws NullPointerException
	{
		if(instructor==null)
		{
			throw new NullPointerException("instructor is null");
		}
		InstructorDAO instructorDAO=new InstructorDAO();
        List<Instructor> list=instructorDAO.getAllInstructor();
        System.out.println(list);
        if(list.stream().filter(i->i.getName().equals(instructor.getName())).findAny().orElse(null)==null) {
		instructorDAO.add(instructor);
		
		return true;
        }
        else {
        	return false;
        }
       
		
	}
	public Instructor verifyUser(String username,String password) throws EmptyFieldException 
	{
		Instructor instructor=null;
		
		if( username.isEmpty() || password.isEmpty()) {
			throw new EmptyFieldException("username or password is empty");
        }
		else {
		    
			InstructorDAO instructorDAO=new InstructorDAO();
	        List<Instructor> list=instructorDAO.getAllInstructor();
			
	    	instructor=list.stream().filter(instructorDTO->instructorDTO.getUsername().equals(username) && instructorDTO.getPassword().equals(password))
	    	.findFirst().orElse(null);
	    	
	    	
		}
		return instructor;
		
	}

}
