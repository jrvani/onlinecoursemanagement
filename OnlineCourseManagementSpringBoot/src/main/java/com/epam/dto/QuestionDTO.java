package com.epam.dto;

public class QuestionDTO {
	
	private int questionId;
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}



	private String questionName;
	QuestionDTO(){}
	
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
	
	

	@Override
	public String toString() {
		return "QuestionDTO [questionName=" + questionName + "]";
	}

}
