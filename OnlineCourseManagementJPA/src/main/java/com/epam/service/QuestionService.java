package com.epam.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dao.QuestionDAOInterface;
import com.epam.entity.Assignment;
import com.epam.entity.Question;
import com.epam.exceptions.AssignmentNotFound;

public class QuestionService {
	private static final Logger LOGGER = LogManager.getLogger(QuestionService.class);
	QuestionDAOInterface questionDAOInterface;
	public QuestionService(QuestionDAOInterface questionDAOInterface) {
		this.questionDAOInterface=questionDAOInterface;
	}
	public Assignment getAssignment(String a) throws AssignmentNotFound
	{
		if(questionDAOInterface.getAssignment(a)==null)
		{
			throw new AssignmentNotFound("assignment not found");
		}
		return questionDAOInterface.getAssignment(a);
	}
	public void add(Assignment assignment,Question q)
	{
		q.setAssignment(assignment);
		questionDAOInterface.add(q);
	}
	public void view(Assignment a)
	{
		for(Question q:questionDAOInterface.view(a))
		{
			LOGGER.info(q);
		}
	}
	
	public void deleteQuestion(Assignment assignment,int id)
	{
		questionDAOInterface.delete(assignment,id);
		
	}

}
