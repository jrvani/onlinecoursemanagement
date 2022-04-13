package com.epam.ui;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.service.EmptyFieldException;
import com.epam.service.Validation;




public class Registration {
	
	private static final Logger LOGGER=LogManager.getLogger(Registration.class);
	public boolean register()
	{
		boolean registerFlag=true;
		
		try (Scanner sc = new Scanner(System.in)) {
			LOGGER.debug("Enter your name: ");
			String name=sc.nextLine();
			LOGGER.debug("Enter your email: ");
			String email=sc.nextLine();
			LOGGER.debug("Enter your username: ");
			String username=sc.nextLine();
			LOGGER.debug("Enter your password: ");
			String password=sc.nextLine();
			List<CourseDTO> userCourse=new ArrayList<>();
			try {
				if(!name.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty())
				{
					InstructorDTO instructorDTO=new InstructorDTO(name,email,username,password,userCourse);
					Validation valid=new Validation();
					boolean b=valid.register(instructorDTO);
					if(b)
					{
						LOGGER.debug("Registered Sucessfully");
					}
					else {
						LOGGER.debug("You are already registered user Please login");
					}
					
				}
				else
				{
					registerFlag=false;
					extracted();
				}
				
			}
			catch(EmptyFieldException ex)
			{
				LOGGER.error(ex.getMessage());
			}
		}
		return registerFlag;
		
		
	}
	private void extracted() throws EmptyFieldException {
		throw new EmptyFieldException("You have one or more fields as empty");
	}

}
