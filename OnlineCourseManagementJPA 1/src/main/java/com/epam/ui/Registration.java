package com.epam.ui;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.entity.*;
import com.epam.service.*;



public class Registration {
	static int id=0;
	private static final Logger LOGGER=LogManager.getLogger(Registration.class);
	public boolean register()
	{
		boolean registerFlag=true;
		
		Scanner sc = new Scanner(System.in);
			LOGGER.debug("Enter your name: ");
			String name=sc.nextLine();
			LOGGER.debug("Enter your username: ");
			String username=sc.nextLine();
			LOGGER.debug("Enter your password: ");
			String password=sc.nextLine();
			List<Course> userCourse=new ArrayList<>();
			try {
				if(!name.isEmpty() && !username.isEmpty() && !password.isEmpty())
				{
					Instructor instructor=new Instructor(name,username,password,userCourse);
					Validation valid=new Validation();
					boolean b=valid.register(instructor);
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
