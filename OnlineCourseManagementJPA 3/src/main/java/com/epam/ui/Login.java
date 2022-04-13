package com.epam.ui;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dto.InstructorDTO;
import com.epam.service.EmptyFieldException;
import com.epam.service.Validation;
import com.epam.utility.ScannerUtil;
public class Login {
	private static final Logger LOGGER=LogManager.getLogger(Login.class);
	public void login()
	{
		boolean verify=false;
		Scanner sc = new Scanner(System.in);
			while(!verify) {
				LOGGER.debug("Login");
				LOGGER.debug("Enter username");
				String username=sc.nextLine();
			
				LOGGER.debug("Enter password");
				String password=sc.nextLine();
				
			try
			{
				
					InstructorDTO instructorDto=null;
					Validation valid=new Validation();
			        instructorDto=valid.verifyUser(username,password);
			        if(instructorDto!=null)
			        {
			        	verify=true;
			        	LOGGER.debug("Logged in successfully ");
			        	InstructorUI instructorMenu=new InstructorUI();
			        	instructorMenu.menu(instructorDto);
			        	
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
