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
	

	public void add(Assignment assignment,Question q)
	{
		q.setAssignment(assignment);
		questionDAOInterface.save(q);
	}
	
	
	public void deleteQuestion(int id)
	{
		questionDAOInterface.deleteById(id);
		
	}

}
