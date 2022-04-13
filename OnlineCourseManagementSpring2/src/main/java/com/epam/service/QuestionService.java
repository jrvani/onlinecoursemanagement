package com.epam.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.QuestionDAOInterface;
import com.epam.entity.Assignment;
import com.epam.entity.Question;
import com.epam.exceptions.AssignmentNotFound;
@Service
public class QuestionService {
	private static final Logger LOGGER = LogManager.getLogger(QuestionService.class);
	@Autowired
	private QuestionDAOInterface questionDAOInterface;
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
		List<Question> list=questionDAOInterface.view(a);
		for(Question q:list)
		{
			LOGGER.info(q);
		}
	}
	
	public void deleteQuestion(Assignment ass,int id)
	{
		questionDAOInterface.delete(ass,id);
		
	}

}
