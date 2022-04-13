package com.epam.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.epam.dao.InstructorDAO;
import com.epam.dto.InstructorDTO;
import com.epam.entity.*;


public class Validation {
	public boolean register(InstructorDTO instructorDto) throws NullPointerException
	{
		if(instructorDto==null)
		{
			throw new NullPointerException("instructor is null");
		}
		InstructorDAO instructorDAO=new InstructorDAO();
        List<Instructor> list=instructorDAO.getAllInstructor();
        Instructor instructor=convertDtoToEntity(instructorDto);
        System.out.println(list);
        if(list.stream().filter(i->i.getName().equals(instructor.getName())).findAny().orElse(null)==null) {
		instructorDAO.save(instructor);
		
		return true;
        }
        else {
        	return false;
        }
       
		
	}
	public InstructorDTO verifyUser(String username,String password) throws EmptyFieldException 
	{
		Instructor instructor;
		InstructorDTO instructorDto;
		if( username.isEmpty() || password.isEmpty()) {
			throw new EmptyFieldException("username or password is empty");
        }
		else {
		    
			InstructorDAO instructorDAO=new InstructorDAO();
	        List<Instructor> list=instructorDAO.getAllInstructor();
	     
	    	instructor=list.stream().filter(i->i.getUsername().equals(username) && i.getPassword().equals(password))
	    	.findFirst().orElse(null);
	    	instructorDto= convertEntityToDto(instructor);
	    	
		}
		return instructorDto;
		
	}
	public Instructor convertDtoToEntity(InstructorDTO instructorDto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(instructorDto,Instructor.class);
		
	}
	
	public InstructorDTO convertEntityToDto(Instructor i)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(i,InstructorDTO.class);
	}
	public List<InstructorDTO> convertList(List<Instructor> list)
	{
		ModelMapper mapper=new ModelMapper();
		return list.stream().map(i->mapper.map(i,InstructorDTO.class)).collect(Collectors.toList());
	
	}

}
