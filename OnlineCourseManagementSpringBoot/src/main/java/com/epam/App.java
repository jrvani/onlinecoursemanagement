package com.epam;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.ui.Login;
import com.epam.ui.Registration;
import com.epam.utility.ScannerUtil;
@Component
public class App {
	
	private static final Logger LOGGER=LogManager.getLogger(App.class);
    @Autowired
    Login l;
    
    @Autowired
    Registration register;
	public  void menu() {
		
		LOGGER.info("Welcome to Online Course ");
		LOGGER.info("Choose option to get started");
		LOGGER.info("1.Register \n2.Login");
		
		
		Scanner sc = ScannerUtil.getScanner();
		int option = sc.nextInt();
		
			
			if (option == 1) {
			
				if(register.register())
				{
	                 l.login();
				}
				else
				{
					LOGGER.debug("Try again");
				}
			}
			else if(option==2){
				l.login();

			}
			else {
				LOGGER.debug("invalid option");
				
			}
			
	        
	}

}
