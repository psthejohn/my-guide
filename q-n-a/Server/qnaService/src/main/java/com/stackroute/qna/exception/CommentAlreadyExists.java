/**
 * 
 */
package com.stackroute.qna.exception;

/**
 * @author kumaran
 *
 */
@SuppressWarnings("serial")
public class CommentAlreadyExists extends Exception{
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CommentAlreadyExists(String message) {
		super();
		this.message = message;
	}
	
	public String toString() {
		return "Comment Already Exists [ message = "+message+"]";
		
	}

}
