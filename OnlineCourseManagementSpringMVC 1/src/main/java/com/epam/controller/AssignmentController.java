package com.epam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;
import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.exceptions.CourseNotExists;
import com.epam.model_mapper.ModelMapperService;
import com.epam.service.AssignmentService;

@Controller
public class AssignmentController {
	
	@Autowired
	AssignmentService assignmentService;
	
	String courseName;
	Course course;
	int id;
	@RequestMapping("/getCourse")
	public ModelAndView getCourse(@RequestParam String courseName,HttpSession session)
	{
		id =(int)session.getAttribute("id");
		
		ModelAndView modelAndView=new ModelAndView();
		this.courseName=courseName;
		course=assignmentService.getCourses(id, courseName);
		
		modelAndView.setViewName("assignmentOperations");
		return modelAndView;
	}
	
	@PostMapping("/addAssignment")
	public ModelAndView addAssignment(@ModelAttribute AssignmentsDTO assignmentsDTO,HttpSession session) 
	{
		Assignment assignment=ModelMapperService.convertDtoToAssignmentEntity(assignmentsDTO);
		
		ModelAndView modelAndView=new ModelAndView();
	
		
		assignmentService.addAssignments(course, assignment);
		modelAndView.addObject("assignment", assignment.getAssignmentName());
		modelAndView.setViewName("assignmentOperations");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/viewAssignment")
	public ModelAndView viewCourse(HttpSession session)
	{
		id =(int)session.getAttribute("id");
		
		
		
		ModelAndView modelAndView=new ModelAndView();
		List<AssignmentsDTO> list=assignmentService.viewAssignments(course);
		
		
		modelAndView.addObject("ass",list );
		modelAndView.setViewName("viewAssignment");
		return modelAndView;
	}
	
	@RequestMapping(value="/deleteAssignment")
	public ModelAndView deleteCourse(@RequestParam String assignmentName,HttpSession session)
	{
		id =(int)session.getAttribute("id");
		
		
		
		ModelAndView modelAndView=new ModelAndView();
		assignmentService.deleteAssignments(course,assignmentName);
		modelAndView.setViewName("assignmentOperations");
		return modelAndView;
	}
	

}
