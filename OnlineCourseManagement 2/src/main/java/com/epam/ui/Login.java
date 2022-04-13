package com.epam.ui;
import java.util.*;

import com.epam.dao.InstructorDAO;

import com.epam.dto.InstructorDTO;
import com.epam.service.Validation;
public class Login {
	static InstructorDTO instructor=null;
	public void login()
	{
		boolean verify=false;
		Scanner sc=new Scanner(System.in);
		while(!verify) {
		System.out.println("Login");
		
		System.out.println("Enter username");
		String username=sc.next();
		System.out.println("Enter password");
        String password=sc.next();
        Validation valid=new Validation();
        instructor=valid.verifyUser(username,password);
        if(instructor!=null)
        {
        	verify=true;
        	System.out.println("Logged in successfully "+verify);
        	InstructorUI instructorMenu=new InstructorUI();
        	instructorMenu.menu(username,instructor);
        	
        }
        else
        {
        	System.out.println("Try again your username or password is incorrect");
        	verify=false;
        	
        }
		}
		
		
        
	}
	
	
    	

}
