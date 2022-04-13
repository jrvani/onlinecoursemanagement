package com.epam.ui;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dao.InstructorDAO;
import com.epam.dao.InstructorDAOInterface;
import com.epam.exceptions.EmptyFieldException;
import com.epam.service.Validation;
import com.epam.utility.ScannerUtil;
public class Login {
	private static final Logger LOGGER=LogManager.getLogger(Login.class);
	InstructorDAOInterface instructorDAOInterface=new InstructorDAO();
	public void login()
	{
		boolean verify=false;
		Scanner sc = ScannerUtil.getScanner();
			while(!verify) {
				LOGGER.debug("Login");
				LOGGER.debug("Enter username");
				String username=sc.nextLine();
			
				LOGGER.debug("Enter password");
				String password=sc.nextLine();
				
			try
			{
				
				
					Validation valid=new Validation(instructorDAOInterface);
			        int n=valid.verifyUser(username,password);
			        if(n>0)
			        {
			        	verify=true;
			        	LOGGER.debug("Logged in successfully ");
			        	InstructorUI instructorMenu=new InstructorUI();
			        	instructorMenu.menu(n);
			        	
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
