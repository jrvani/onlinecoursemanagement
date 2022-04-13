package com.epam.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.CourseDTO;
import com.epam.entity.Course;
import com.epam.exceptions.CourseNotExists;
import com.epam.exceptions.InstructorNotFound;
import com.epam.model_mapper.ModelMapperService;
import com.epam.service.CourseService;
@Controller
public class CourseContoller {
	
	@Autowired
	CourseService courseService;
	
	int id;
	@RequestMapping(value="/add")
	public ModelAndView addCourse(@ModelAttribute CourseDTO courseDTO,BindingResult result,HttpSession session) throws CourseNotExists
	{
		 id =(int)session.getAttribute("id");
		
		Course course=ModelMapperService.convertDtoToCourseEntity(courseDTO);
		
		ModelAndView modelAndView=new ModelAndView();
		courseService.addCourse(id,course);
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}
	
	@RequestMapping(value="/viewCourse")
	public ModelAndView viewCourse(HttpSession session)
	{
		id =(int)session.getAttribute("id");
		
		
		
		ModelAndView modelAndView=new ModelAndView();
		List<CourseDTO> list=courseService.viewCourse(id);
		
		
		modelAndView.addObject("courseV",list );
		modelAndView.setViewName("view");
		return modelAndView;
	}
	
	@RequestMapping(value="/deleteCourse")
	public ModelAndView deleteCourse(@RequestParam String courseName,HttpSession session)
	{
		id =(int)session.getAttribute("id");
		
		
		
		ModelAndView modelAndView=new ModelAndView();
		courseService.deleteCourse(id,courseName);
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}
	
	

}
