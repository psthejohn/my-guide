package com.stackroute.qna.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "question")
public class Question {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Question_Id")
	private int questionId;

	@Column(name = "Question_Description")
	private String questionDescription;
	
	@CreationTimestamp
	@Column(name = "Question_Date")
	private Date questionDate;
	
	@Column(name="Topic_Id")
	private int topicId;

	@Column(name="User_Id")
	private String userId;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public Date getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public Question(int questionId, String questionDescription, Date questionDate, int topicId, String userId) {
		super();
		this.questionId = questionId;
		this.questionDescription = questionDescription;
		this.questionDate = questionDate;
		this.topicId = topicId;
		this.userId = userId;
	}

	public Question() {
		super();
	}
	
	
	
}
