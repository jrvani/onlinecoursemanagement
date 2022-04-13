package com.epam.ui;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.exceptions.EmptyFieldException;
import com.epam.service.Validation;
import com.epam.utility.ScannerUtil;

@Component
public class Login {
	
	@Autowired
	private Validation valid;
	
	@Autowired
	private InstructorUI instructor;
	
	public Validation getValid() {
		return valid;
	}
	public void setValid(Validation valid) {
		this.valid = valid;
	}
	private static final Logger LOGGER=LogManager.getLogger(Login.class);

	public void login()
	{
		boolean verify=false;
		Scanner sc = ScannerUtil.getScanner();
			while(!verify) {
				
				LOGGER.info("welcome please Login");
				
				LOGGER.info("Enter username");
				String username=sc.nextLine();
			   
				LOGGER.info("Enter password");
				String password=sc.nextLine();
				
			try
			{
				
				
					
			        int n=valid.verifyUser(username,password);
			        if(n>0)
			        {
			        	verify=true;
			        
			        	LOGGER.info("Logged in successfully ");
			          
			        	instructor.menu(n);
			        	
			        }
			        else
			        {
			        	LOGGER.info("Try again your username or password is incorrect");
			        	
			        	
			        	
			        }
				
			}
			catch(EmptyFieldException ex)
			{
				LOGGER.error(ex.getMessage());
			}
			
      
			}
		
		
		
        
	}
	
	
    	

}
