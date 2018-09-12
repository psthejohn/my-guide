package com.stackroute.qna.exception;

@SuppressWarnings("serial")
public class QuestionAlreadyExists extends Exception{

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	public QuestionAlreadyExists(String message) {
		super();
		this.message = message;
	}

	public String toString() {
		return "Question Already Exists [ message = "+message+"]";
		
	}
}
