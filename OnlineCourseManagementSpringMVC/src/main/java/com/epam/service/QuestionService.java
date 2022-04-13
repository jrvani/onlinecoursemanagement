package com.epam.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.QuestionDAO;
import com.epam.entity.Assignment;
import com.epam.entity.Question;
import com.epam.exceptions.AssignmentNotFound;
@Service
public class QuestionService {
	private static final Logger LOGGER = LogManager.getLogger(QuestionService.class);
	@Autowired
	private QuestionDAO questionDAOInterface;
	public QuestionService(QuestionDAO questionDAOInterface) {
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
	public List<Question> view(Assignment a)
	{
		return questionDAOInterface.view(a);
		
	}
	
	public void deleteQuestion(int id)
	{
		questionDAOInterface.delete(id);
		
	}

}
