package com.epam.service;

import java.util.List;

import com.epam.dao.InstructorDAO;
import com.epam.dto.InstructorDTO;

public class Validation {
	public void register(InstructorDTO instructorDTO)
	{
		InstructorDAO instructorDao=new InstructorDAO();
        List<InstructorDTO> list=instructorDao.getInstructors();
		list.add(instructorDTO);
	}
	public InstructorDTO verifyUser(String username,String password)
	{
		InstructorDTO instructor=null;
		InstructorDAO instructorDao=new InstructorDAO();
        List<InstructorDTO> list=instructorDao.getInstructors();
		
    	instructor=list.stream().filter((instructorDTO)->instructorDTO.getUsername().equals(username) && instructorDTO.getPassword().equals(password))
    	.findAny().get();
    	
    	return instructor;
    }

}
