package com.epam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.service.Validation;

@Controller
public class Login {
	
	@Autowired
	Validation validation;
	
	@RequestMapping(value="/login")
	public ModelAndView loadLogin(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session)
	{
	
		ModelAndView modelAndView=new ModelAndView();
		int n=validation.verifyUser(username, password);
		if(n>0 ) {
			session.setAttribute("id", n);
			session.setAttribute("username",username);
		modelAndView.setViewName("dashboard");
		}
		else {
			modelAndView.setViewName("error");
		}

		return modelAndView;
	}
    
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpSession session)
	{
		ModelAndView modelAndView=new ModelAndView();
		session.removeAttribute("id");
		modelAndView.setViewName("login");
		return modelAndView;
	}
}
