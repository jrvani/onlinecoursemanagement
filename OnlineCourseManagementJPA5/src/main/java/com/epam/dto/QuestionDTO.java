package com.epam.dto;

public class QuestionDTO {
	
	private String questionName;
	
	public QuestionDTO(String questionName)
	{
		this.questionName=questionName;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionNameString) {
		this.questionName = questionNameString;
	}
	
	

}
