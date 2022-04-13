package com.epam;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.ui.Login;
import com.epam.ui.Registration;
import com.epam.utility.ScannerUtil;

public class App {
	private static final Logger LOGGER=LogManager.getLogger(App.class);
	
	public static void main(String[] args) {
		
		
		LOGGER.info("Welcome to Online Course ");
		LOGGER.info("Choose option to get started");
		LOGGER.info("1.Register \n2.Login");
		
		
		Scanner sc = ScannerUtil.getScanner();
		int option = sc.nextInt();
		 ApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
		Login l=context.getBean(Login.class);
		if (option == 1) {
			Registration register=context.getBean(Registration.class);
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
