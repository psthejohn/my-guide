package com.stackroute.qna.exception;

@SuppressWarnings("serial")
public class QuestionDoesNotExists extends Exception{
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

		
	public QuestionDoesNotExists(String message) {
		super();
		this.message = message;
	}

	public String toString() {
		return "Question does not Exists [ message = "+message+"]";
		
	}

}
