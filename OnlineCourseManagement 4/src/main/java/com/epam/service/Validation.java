package com.epam.service;

import java.util.List;

import com.epam.dao.InstructorDAO;
import com.epam.dto.InstructorDTO;

public class Validation {
	public boolean register(InstructorDTO instructorDTO) throws NullPointerException
	{
		if(instructorDTO==null)
		{
			throw new NullPointerException("instructor is null");
		}
		InstructorDAO instructorDAO=new InstructorDAO();
        List<InstructorDTO> list=instructorDAO.getInstructors();
        if(list.stream().filter(i->i.getName().equals(instructorDTO.getName())).findAny().orElse(null)==null) {
		list.add(instructorDTO);
		return true;
        }
        else {
        	return false;
        }
       
		
	}
	public InstructorDTO verifyUser(String username,String password) throws EmptyFieldException 
	{
		InstructorDTO instructor=null;
		
		if( username.isEmpty() || password.isEmpty()) {
			throw new EmptyFieldException("username or password is empty");
        }
		else {
		    
			InstructorDAO instructorDAO=new InstructorDAO();
	        List<InstructorDTO> list=instructorDAO.getInstructors();
			
	    	instructor=list.stream().filter(instructorDTO->instructorDTO.getUsername().equals(username) && instructorDTO.getPassword().equals(password))
	    	.findFirst().orElse(null);
	    	
	    	
		}
		return instructor;
		
	}

}
