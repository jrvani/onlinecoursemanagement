package com.epam.ui;
import java.util.*;

import com.epam.dao.InstructorDAO;

import com.epam.dto.InstructorDTO;
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
        InstructorDAO instructorDao=new InstructorDAO();
        List<InstructorDTO> list=instructorDao.getInstructors();
        verify=verifyUser(list,username,password);
        if(verify)
        {
        	System.out.println("Logged in successfully "+verify);
        	InstructorUI instructorMenu=new InstructorUI();
        	System.out.println(instructor);
        	instructorMenu.menu(username,instructor);
        	break;
        }
        else
        {
        	System.out.println("Try again your username or password is incorrect");
        	
        }
		}
		sc.close();
		
        
	}
	
	public static boolean verifyUser(List<InstructorDTO> list,String username,String password)
    {
    	boolean flag=false;
    	for(InstructorDTO instructorDTO:list)
    	{
    		if(instructorDTO.getUsername().equals(username) && instructorDTO.getPassword().equals(password))
    		{
    		   
    		   instructor=instructorDTO;
    		   System.out.println("lll"+instructor);
    		   flag=true;
    		   break;
    			
    		}
    	}
    	return flag;
    }
    	

}
