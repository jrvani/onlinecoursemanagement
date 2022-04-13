package com.epam.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.InstructorDAOInterface;
import com.epam.dto.InstructorDTO;
import com.epam.entity.Instructor;
import com.epam.exceptions.EmptyFieldException;
import com.epam.exceptions.ListNotFound;

@Service
public class Validation {
	
	@Autowired
   InstructorDAOInterface instructorDaoInterface;
	
	public Validation(InstructorDAOInterface instructorDaoInterface) {
		this.instructorDaoInterface=instructorDaoInterface;
	
	}
	

	public List<Instructor> getInstructors() throws ListNotFound
	{
		 List<Instructor> list=instructorDaoInterface.getAllInstructor();
		 if(list==null)
		 {
			 throw new ListNotFound("list is empty no data");
		 }
		 return list;
	}
	public boolean register(InstructorDTO instructorDto) throws NullPointerException,ListNotFound
	{
		boolean flag=true;
	
		if(instructorDto==null)
		{
			throw new NullPointerException("instructor is null");
		}
		
    
      
        for(Instructor i:getInstructors())
        {
        	if(i.getName().equals(instructorDto.getName()) && i.getUsername().equals(instructorDto.getUsername()))
        	{
        		
        		flag=false;
        		break;
        	}
        }
        if(flag) {
        	instructorDaoInterface.save(instructorDto);

        
        }
        return flag;
 
	}
	
	
	
	public int verifyUser(String username,String password) throws EmptyFieldException 
	{
		
		if( username.isEmpty() || password.isEmpty()) {
			throw new EmptyFieldException("username or password is empty");
        }
		
	        List<Instructor> list=instructorDaoInterface.getAllInstructor();
	     
	        for(Instructor i:list)
	        {
	        	if(i.getUsername().equals(username) && i.getPassword().equals(password))
	        	{
	        		
	        		return i.getInstructorId();
	        		
	        	}
	        }
	    	
		
		return 0;
		
	}
	

}
