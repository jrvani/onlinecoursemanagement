package com.epam;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.ui.*;
import com.epam.utility.ScannerUtil;

public class App {
	private static final Logger LOGGER=LogManager.getLogger(App.class);
	
	public static void main(String[] args) {
		
		
		LOGGER.info("Welcome to Online Course Portal");
		LOGGER.info("Choose option to get started");
		LOGGER.info("1.Register \n2.Login");
		
		
		Scanner sc = ScannerUtil.getScanner();
		int option = sc.nextInt();
		Login l=new Login();
		if (option == 1) {
			Registration register=new Registration();
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
