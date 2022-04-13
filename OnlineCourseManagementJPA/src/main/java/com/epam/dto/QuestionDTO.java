package com.epam.dto;

public class QuestionDTO {
	
	@Override
	public String toString() {
		return "QuestionDTO [questionName=" + questionName + "]";
	}

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
