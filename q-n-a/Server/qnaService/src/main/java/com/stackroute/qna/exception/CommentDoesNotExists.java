package com.stackroute.qna.exception;

@SuppressWarnings("serial")
public class CommentDoesNotExists extends Exception{
	

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

		
	public CommentDoesNotExists(String message) {
		super();
		this.message = message;
	}

	public String toString() {
		return "Question does not Exists [ message = "+message+"]";
		
	}

}
