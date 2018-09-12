package com.stackroute.qna.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Comment_Id")
	private int commentId;

	@Column(name = "Comment_Description")
	private String commentDescription;
	
	@CreationTimestamp
	@Column(name = "Commented_Date")
	private Date commentedDate;
	
	@Column(name = "Question_Id")
	private int questionId;
	
	@Column(name = "User_Id")
	private String userId;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public Date getCommentedDate() {
		return commentedDate;
	}

	public void setCommentedDate(Date commentedDate) {
		this.commentedDate = commentedDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Comment(int commentId, String commentDescription, Date commentedDate, int questionId, String userId) {
		super();
		this.commentId = commentId;
		this.commentDescription = commentDescription;
		this.commentedDate = commentedDate;
		this.questionId = questionId;
		this.userId = userId;
	}

	public Comment() {
		super();
	}
	
	
	
	
	
}
