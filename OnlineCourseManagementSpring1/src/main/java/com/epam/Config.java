package com.epam;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan
public class Config {
	
	/*@Bean 
	public CourseDAOInterface getCourseDAOInterface()
	{
		
		return new CourseDAO();
	}
	
	@Bean
	public CourseService getCourseService()
	{
		CourseService cService=new CourseService(getCourseDAOInterface());
		return cService;
	}
	
	@Bean 
	public CourseUI getCourseUI()
	{
		CourseUI courseUI=new CourseUI();
		courseUI.setCourseService(getCourseService());
		return courseUI;
	}
	
    @Bean
    public InstructorUI getInstructorUI()
    {
    	InstructorUI instructorUI=new InstructorUI();
    	instructorUI.setCourse(getCourseUI());
    	return instructorUI;
    }
	
   
	@Bean
	public InstructorDAOInterface getInstructorDAOInterface()
	{
		InstructorDAOInterface instructorDAOInterface=new InstructorDAO();
		return instructorDAOInterface;
	}
	@Bean
	public Validation get()
	{
		Validation validation=new Validation(getInstructorDAOInterface());
	
		return validation;
	}
	@Bean
	public Login getlogin()
	{
		Login login=new Login();
		login.setValid(get());
		login.setIns(getInstructorUI());
		return login;
		
	}
	
	@Bean
	public Registration getRegistration()
	{
		Registration registration=new Registration();
		registration.setValid(get());
		return registration;
	}
	
   
	
	@Bean 
	public AssignmentDAOInterface getAssigmentDAOInterface()
	{
		AssignmentDAOInterface assignmentDAOInterface=new AssignmentDAO();
		return assignmentDAOInterface;
	}
	
	@Bean
	public AssignmentService getAssignmentService()
	{
		AssignmentService cService=new AssignmentService(getAssigmentDAOInterface());
		return cService;
	}
	
	@Bean 
	public AssignmentUI getAssignmentUI()
	{
		AssignmentUI assignment=new AssignmentUI();
		assignment.setAssignmentService(getAssignmentService());
		return assignment;
	}
	
	@Bean 
	public QuestionDAOInterface getQuestionDAOInterface()
	{
		QuestionDAOInterface questionDAOInterface=new QuestionDAO();
		return questionDAOInterface;
	}
	
	@Bean
	public  QuestionService getQuestionService()
	{
		QuestionService cService=new QuestionService(getQuestionDAOInterface());
		return cService;
	}
	
	@Bean 
	public QuestionUI getQuestionUI()
	{
		QuestionUI question=new QuestionUI();
		question.setQuestionService(getQuestionService());
		return question;
	}
	*/
}
