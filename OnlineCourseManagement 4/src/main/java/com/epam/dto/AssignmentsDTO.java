package com.epam.dto;

import java.util.*;

public class AssignmentsDTO {
	String assignmentName;
	String assignmentId;
	String deadline;
	int score;
	List<String> questions;

	public AssignmentsDTO(String assignmentName, String assignmentId, String deadline, int score, List<String> questions) {
		this.assignmentName = assignmentName;
		this.assignmentId = assignmentId;
		this.deadline = deadline;
		this.score = score;
		this.questions = questions;

	}
	public String getAssignmentName()
	{
		return assignmentName;
	}
	public String toString()
	{
		return "Assignment Name : "+assignmentName+"\n"+"AssignmentID : "+assignmentId+"\n"
			+"DeadLine : "+deadline+"\n"+"Score : "+score+"\n"+"Questions : "+questions+"\n";
	}

}
