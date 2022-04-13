package com.epam.dto;

import org.springframework.stereotype.Component;


public class AssignmentsDTO {
	private String assignmentName;
	private String deadline;
	private int score;

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
