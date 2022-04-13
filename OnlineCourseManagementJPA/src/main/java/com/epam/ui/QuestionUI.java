package com.epam.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.dao.QuestionDAO;
import com.epam.dao.QuestionDAOInterface;
import com.epam.dto.QuestionDTO;
import com.epam.entity.Assignment;
import com.epam.entity.Question;
import com.epam.exceptions.AssignmentNotFound;
import com.epam.model_mapper.ModelMapperService;
import com.epam.service.QuestionService;
import com.epam.utility.ScannerUtil;

public class QuestionUI {
	private static final Logger LOGGER = LogManager.getLogger(QuestionUI.class);
	Assignment assignment;
	
	public void questionMenu(String assignmentName) {
		
		QuestionDAOInterface questionDAOInterface = new QuestionDAO();
		QuestionService questionService = new QuestionService(questionDAOInterface);
		try {
		 assignment = questionService.getAssignment(assignmentName);
		}
		catch(AssignmentNotFound e)
		{
			LOGGER.error(e.getMessage());
		}
		int n = 0;
		Scanner sc =ScannerUtil.getScanner();
		while (n < 4) {
			LOGGER.info("Choose options \n 1.Add Question \n 2.view Question \n 3.Delete Question\n 4.LogOut");
           
			n = sc.nextInt();

			switch (n) {

			case 1:
				sc.nextLine();
				LOGGER.info("Enter Question");
			    String questionString=sc.nextLine();
               
				QuestionDTO questionDTO = new QuestionDTO(questionString);
				Question question = ModelMapperService.convertDtoToQuestionEntity(questionDTO);
				questionService.add(assignment, question);

				break;
			case 2:
				LOGGER.info(" Question");
				questionService.view(assignment);
				break;
			case 3:
				LOGGER.info("Enter Question id");
				int questionId = sc.nextInt();
				
				questionService.deleteQuestion(assignment, questionId);
				break;
			case 4:
				LOGGER.info("log out");
				break;
			default:
				LOGGER.info("no val");
				
			}

		}
	}
}
