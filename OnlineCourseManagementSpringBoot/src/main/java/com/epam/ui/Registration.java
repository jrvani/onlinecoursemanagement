package com.epam.ui;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.exceptions.EmptyFieldException;
import com.epam.service.Validation;
import com.epam.utility.ScannerUtil;


@Component
public class Registration {
	static int id=0;
	
	@Autowired
	private Validation valid;
	
	
	
	public Validation getValid() {
		return valid;
	}
	public void setValid(Validation valid) {
		this.valid = valid;
	}
	
	
	private static final Logger LOGGER=LogManager.getLogger(Registration.class);
	public boolean register()
	{
		boolean registerFlag=true;
		
		Scanner sc =ScannerUtil.getScanner();
			LOGGER.info("Enter your name: ");
			
			String name=sc.nextLine();
			
			LOGGER.info("Enter your username: ");
			
			String username=sc.nextLine();
			
			LOGGER.info("Enter your password: ");
			String password=sc.nextLine();
		   
			List<CourseDTO> userCourse=new ArrayList<>();
			try {
				if(!name.isEmpty() && !username.isEmpty() && !password.isEmpty())
				{
					InstructorDTO instructorDto=new InstructorDTO(name,username,password,userCourse);
					
					
					boolean b=valid.register(instructorDto);
					if(b)
					{
						LOGGER.info("Registered Sucessfully");
					}
					else {
						LOGGER.info("You are already registered user Please login");
					}
					
				}
				else
				{
					registerFlag=false;
					extracted();
				}
				
			}
			catch(Exception ex)
			{
				LOGGER.error(ex.getMessage());
			}
		
		return registerFlag;
		
		
	}
	private void extracted() throws EmptyFieldException {
		throw new EmptyFieldException("You have one or more fields as empty");
	}

}
