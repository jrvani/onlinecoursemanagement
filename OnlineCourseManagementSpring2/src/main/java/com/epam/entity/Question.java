package com.epam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	
	@Entity
	@Table(name="question")
	public class Question {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="question_id")
		private int questionId;
		

		@Column(name="question")
		private String questionName;
		
		@ManyToOne
		private Assignment assignment;
		
		
		
		
		public int getQuestionId() {
			return questionId;
		}





		public void setQuestionId(int questionId) {
			this.questionId = questionId;
		}





		public String getQuestionName() {
			return questionName;
		}





		public void setQuestionName(String questionName) {
			this.questionName = questionName;
		}





		public Assignment getAssignment() {
			return assignment;
		}





		public void setAssignment(Assignment assignment) {
			this.assignment = assignment;
		}





		
		
		

		public String toString()
		{
			return "Questions: "+questionName+"\n";
		}

	}


