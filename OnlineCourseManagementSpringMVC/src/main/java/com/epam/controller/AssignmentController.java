package com.epam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.AssignmentsDTO;
import com.epam.dto.CourseDTO;
import com.epam.dto.QuestionDTO;
import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.entity.Question;
import com.epam.exceptions.AssignmentNotFound;
import com.epam.exceptions.CourseNotExists;
import com.epam.model_mapper.ModelMapperService;
import com.epam.service.AssignmentService;
import com.epam.service.QuestionService;

@Controller
public class AssignmentController {
	
	@Autowired
	AssignmentService assignmentService;
	
	@Autowired
	QuestionService questionService;
	
	Course course;
	Assignment assignment;
	int id;
	@GetMapping("/loadAssignment")
	public ModelAndView loadForm()
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("assignmentForm");
		return modelAndView;
	}

	
	@PostMapping("/getCourse")
	public String getCourse(@RequestParam String courseName,HttpSession session)
	{
		id =(int)session.getAttribute("id");
		course=assignmentService.getCourses(id, courseName);
		return "redirect:/loadAssQues";
	}
	

	
	@RequestMapping(value="/loadAssQues",method=RequestMethod.GET)
	public ModelAndView load()
	{
		ModelAndView modelAndView=new ModelAndView();
		List<AssignmentsDTO> list=assignmentService.viewAssignments(course); 
		modelAndView.addObject("ass",list);
		modelAndView.setViewName("viewAssignment");
		return modelAndView;
	}
	
	@GetMapping("loadAddAssignment")
	public ModelAndView loadAddAssignment()
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("assignmentsDTO", new AssignmentsDTO());
		
		modelAndView.setViewName("addAssignment");
		return modelAndView;
	}
	
	@PostMapping("/addAssignment")
	public String addAssignment(@Valid @ModelAttribute("assignmentsDTO") AssignmentsDTO assignmentsDTO,BindingResult result) 
	{
		assignment=ModelMapperService.convertDtoToAssignmentEntity(assignmentsDTO);
		if(result.hasErrors()) {
			return "addAssignment";
		}
	    assignmentService.addAssignments(course, assignment);
		return "redirect:/loadAssQues";
	}
	
	@GetMapping("/loadaddQuestion")
	public String loadQuestions(@RequestParam("aid") String aid)
	{
		int id=Integer.parseInt(aid);
		assignment=assignmentService.find(id);
		return "addQuestion";
	}
	
	@PostMapping("/addQuestion")
	public String addQuestion(@ModelAttribute QuestionDTO questionDto) 
	{
		Question question=ModelMapperService.convertDtoToQuestionEntity(questionDto);
		questionService.add(assignment, question);
		return "redirect:/loadAssQues";
	}
	
	
	
	
	@RequestMapping(value="/deleteAssignment")
	public String deleteAssignment(@RequestParam("assname") String assname)
	{
		assignmentService.deleteAssignments(course,assname);
		return "redirect:/loadAssQues";
	}
	
	@RequestMapping(value="/deleteQuestion")
	public String deleteQuestion(@RequestParam("qid") String qid)
	{
		int id=Integer.parseInt(qid);
		System.out.println(id);
		questionService.deleteQuestion(id);
		return "redirect:/loadAssQues";
	}
	

}
