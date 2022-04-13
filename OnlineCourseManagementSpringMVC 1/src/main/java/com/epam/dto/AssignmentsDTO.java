package com.epam.dto;

import java.util.ArrayList;
import java.util.List;

public class AssignmentsDTO {
	private int assignmentId;
	private String assignmentName;
	private String deadline;
	private int score;
    private List<QuestionDTO>questions=new ArrayList<QuestionDTO>();
  
	public AssignmentsDTO() {}
	public AssignmentsDTO(String assignmentName, String deadline, int score) {
		this.assignmentName = assignmentName;

		this.deadline = deadline;
		this.score = score;
		
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
	  public List<QuestionDTO> getQuestions() {
			return questions;
		}
		public void setQuestions(List<QuestionDTO> questions) {
			this.questions = questions;
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
			+"DeadLine : "+deadline+"\n"+"Score : "+score+"\n"+"Questions :"+questions;
	}
	/**
	 * @return the assignmentId
	 */
	public int getAssignmentId() {
		return assignmentId;
	}
	/**
	 * @param assignmentId the assignmentId to set
	 */
	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

}
