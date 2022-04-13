package com.epam.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.epam.exceptions.CourseNotExists;
import com.epam.exceptions.InstructorNotFound;

@ControllerAdvice
public class ControllerExceptionHandling {
	
	@ExceptionHandler(value= CourseNotExists.class)
	public ModelAndView coureseException(Exception e)
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message", e.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}
	
	@ExceptionHandler(value= InstructorNotFound.class)
	public ModelAndView instructorException(Exception e)
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message", e.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
