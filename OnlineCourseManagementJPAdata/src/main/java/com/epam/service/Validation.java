package com.epam.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.InstructorDAO;
import com.epam.dto.InstructorDTO;
import com.epam.entity.Instructor;
import com.epam.exceptions.EmptyFieldException;
import com.epam.exceptions.ListNotFound;
import com.epam.model_mapper.ModelMapperService;

@Service
public class Validation {
	
	@Autowired
   InstructorDAO instructorDaoInterface;
	
	

	public List<Instructor> getInstructors() throws ListNotFound
	{
		 List<Instructor> list=instructorDaoInterface.findAll();
		 if(list==null)
		 {
			 throw new ListNotFound("list is empty no data");
		 }
		 return list;
	}public boolean register(InstructorDTO instructorDTO) throws ListNotFound
	{
		boolean flag=true;
	
		 List<Instructor> list=getInstructors();
        for(Instructor i:list)
        {
        	if(i.getName().equals(instructorDTO.getName()) && i.getUsername().equals(instructorDTO.getUsername()))
        	{
        		
        		flag=false;
        		break;
        	}
        }
        
       
        if(flag) {
        	 Instructor instructor=	ModelMapperService.convertDtoToInsEntity(instructorDTO);
        	instructorDaoInterface.save(instructor);

        
        }
        return flag;
 
	}
	
	
	
	public int verifyUser(String username,String password) 
	{
		
		
		
	        List<Instructor> list=instructorDaoInterface.findAll();
	     
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
