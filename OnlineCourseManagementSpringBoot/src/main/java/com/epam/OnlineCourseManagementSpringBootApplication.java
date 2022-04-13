package com.epam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OnlineCourseManagementSpringBootApplication implements CommandLineRunner {
     
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(OnlineCourseManagementSpringBootApplication.class, args);
		App app=context.getBean(App.class);
		app.menu();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
