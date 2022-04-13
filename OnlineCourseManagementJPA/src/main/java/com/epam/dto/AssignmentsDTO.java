package com.epam.dto;

import java.util.List;

import com.epam.entity.Question;

public class AssignmentsDTO {
	private String assignmentName;
	private String deadline;
	private int score;
	private List<QuestionDTO> questionList;

    public AssignmentsDTO() {}
	public AssignmentsDTO(String assignmentName, String deadline, int score,List<QuestionDTO> questionList) {
		this.assignmentName = assignmentName;

		this.deadline = deadline;
		this.score = score;
		this.questionList=questionList;
		
	}
	
	public List<QuestionDTO> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<QuestionDTO> questionList) {
		this.questionList = questionList;
	}
	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String toString()
	{
		return "Assignment Name : "+assignmentName+"\n"
			+"DeadLine : "+deadline+"\n"+"Score : "+score+"\n";
	}

}
