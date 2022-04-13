package com.epam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OnlineCourseManagementSpringMvcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCourseManagementSpringMvcApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lll");
		
	}

}
