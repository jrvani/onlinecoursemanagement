package com.epam.ui;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dao.InstructorDAO;
import com.epam.dao.InstructorDAOInterface;
import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.exceptions.EmptyFieldException;
import com.epam.service.Validation;
import com.epam.utility.ScannerUtil;



public class Registration {
	static int id=0;
	InstructorDAOInterface instructorDAOInterface=new InstructorDAO();
	private static final Logger LOGGER=LogManager.getLogger(Registration.class);
	public boolean register()
	{
		boolean registerFlag=true;
		
		Scanner sc =ScannerUtil.getScanner();
			LOGGER.info("Enter your name: ");
			String name=sc.nextLine();
			//System.out.println(name);
			LOGGER.info("Enter your username: ");
			String username=sc.nextLine();
			//System.out.println(username);
			LOGGER.info("Enter your password: ");
			String password=sc.nextLine();
			System.out.println(name+" "+username+" "+password);
			List<CourseDTO> userCourse=new ArrayList<>();
			try {
				if(!name.isEmpty() && !username.isEmpty() && !password.isEmpty())
				{
					InstructorDTO instructorDto=new InstructorDTO(name,username,password,userCourse);
					Validation valid=new Validation(instructorDAOInterface);
					boolean b=valid.register(instructorDto);
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
