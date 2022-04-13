package com.epam.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="assignment")
public class Assignment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="assignment_id")
	private int assignmentId;
	@Column(name="assignment_name")
	private String assignmentName;
	@Column(name="deadline")
	private String deadline;
	@Column(name="score")
	private int score;
	
	@ManyToOne
	private Course course;
	@OneToMany(mappedBy = "assignment",cascade = CascadeType.ALL)
	List<Question> questionList;
	
	
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public Assignment()
	{
		
	}
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Assignment(String assignmentName, String deadline, int score,List<Question> list) {
		this.assignmentName = assignmentName;
		this.deadline = deadline;
		this.score = score;
		this.questionList=list;
	

	}
	
	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
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
		return "Assignment Name : "+assignmentName+"\n"+"AssignmentID : "+assignmentId+"\n"
			+"DeadLine : "+deadline+"\n"+"Score : "+score+"\n"+questionList;
	}

}
