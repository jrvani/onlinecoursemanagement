package com.epam.ui;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.epam.dto.InstructorDTO;
import com.epam.service.EmptyFieldException;
import com.epam.service.Validation;
public class Login {
	private static final Logger LOGGER=LogManager.getLogger(Login.class);
	public void login()
	{
		boolean verify=false;
		try (Scanner sc = new Scanner(System.in)) {
			while(!verify) {
				LOGGER.debug("Login");
				LOGGER.debug("Enter username");
				String username=sc.nextLine();
				LOGGER.debug("Enter password");
				String password=sc.nextLine();
				
			try
			{
				
					InstructorDTO instructor=null;
					Validation valid=new Validation();
			        instructor=valid.verifyUser(username,password);
			        if(instructor!=null)
			        {
			        	verify=true;
			        	LOGGER.debug("Logged in successfully ");
			        	InstructorUI instructorMenu=new InstructorUI();
			        	instructorMenu.menu(instructor);
			        	
			        }
			        else
			        {
			        	LOGGER.debug("Try again your username or password is incorrect");
			        	
			        	
			        }
				
			}
			catch(EmptyFieldException ex)
			{
				LOGGER.error(ex.getMessage());
			}
			
      
			}
		}
		
		
        
	}
	
	
    	

}
