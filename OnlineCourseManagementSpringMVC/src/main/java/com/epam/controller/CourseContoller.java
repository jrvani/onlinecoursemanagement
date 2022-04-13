package com.epam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.CourseDTO;
import com.epam.dto.InstructorDTO;
import com.epam.entity.Course;
import com.epam.exceptions.CourseNotExists;
import com.epam.model_mapper.ModelMapperService;
import com.epam.service.CourseService;
@Controller
public class CourseContoller {
	
	@Autowired
	CourseService courseService;
	
	int id;
	@GetMapping("/loadCourses")
	public ModelAndView loadCourse(HttpSession session)
	{
		id =(int)session.getAttribute("id");
		
		ModelAndView modelAndView=new ModelAndView();
		List<CourseDTO> list=courseService.viewAllCourse(id);
		
		
		modelAndView.addObject("courseV",list );
		
		modelAndView.setViewName("courses");
		return modelAndView;
	}
	
	@GetMapping("loadAddCourse")
	public ModelAndView loadAddCourse()
	{
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("courseDTO", new CourseDTO());
		modelAndView.setViewName("addCourse");
		return modelAndView;
	}
	
	@PostMapping(value="/add")
	public String addCourse(@Valid @ModelAttribute("courseDTO") CourseDTO courseDTO,BindingResult result,HttpSession session) throws CourseNotExists
	{
		id =(int)session.getAttribute("id");
		if(result.hasErrors()) { return "addCourse";}   //addCourse.jsp
		else {
		Course course=ModelMapperService.convertDtoToCourseEntity(courseDTO);
		
		courseService.addCourse(id,course);
		
		}
		return "redirect:/loadCourses";
	}
	
	@RequestMapping(value="/view")
	public ModelAndView view(@RequestParam("cid") String cid)
	{
		
		int cid1=Integer.parseInt(cid);
		ModelAndView modelAndView=new ModelAndView();
		CourseDTO course=courseService.viewCourse(cid1);
		
		modelAndView.addObject("course",course );
		modelAndView.setViewName("view");
		return modelAndView;
		
	}
	
	
	@GetMapping("/loaddelete")
	public String loaddelete(@RequestParam("cname") String cname,HttpSession session)
	{
		
		
		id =(int)session.getAttribute("id");
		courseService.deleteCourse(id,cname);
		
		return "redirect:/loadCourses";
	}

	
	

}
