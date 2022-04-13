package com.epam;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.ui.*;

public class App {
	private static final Logger LOGGER=LogManager.getLogger(App.class);
	public static Scanner sc;
	public static void main(String[] args) {
		
		
		LOGGER.debug("Welcome to Online Course Portal");
		LOGGER.debug("Choose option to get started");
		LOGGER.debug("1.Register \n2.Login");
		
		
		sc = new Scanner(System.in);
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
		
         sc.close();
	}

}
