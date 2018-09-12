/**
 * 
 */
package com.stackroute.qna.exception;

/**
 * @author kumaran
 *
 */
@SuppressWarnings("serial")
public class TopicAlreadyExists extends Exception{

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

		
	public TopicAlreadyExists(String message) {
		super();
		this.message = message;
	}

	public String toString() {
		return "Topic Already Exists [ message = "+message+"]";
		
	}
	
}
