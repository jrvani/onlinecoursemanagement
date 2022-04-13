package com.epam;

import java.util.*;

import com.epam.ui.*;

public class App {
	public static void main(String[] args) {
		
		System.out.println("Welcome to Online Course Portal");
		System.out.println("Choose option to get started");
		System.out.println("1.Register");
		System.out.println("2.Login");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		Login l=new Login();
		if (option == 1) {
			Registration r=new Registration();
			//boolean b = r.register();
			if(r.register())
			{
			System.out.println("Registered Sucessfully");
			
			l.login();
			}
			else
			{
				System.out.println("Try again");
			}
		} else {
			l.login();

		}
		

	}

}
