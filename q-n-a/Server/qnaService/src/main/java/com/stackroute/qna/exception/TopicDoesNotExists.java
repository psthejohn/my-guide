/**
 @author kumaran
 *
 */
package com.stackroute.qna.exception;


@SuppressWarnings("serial")
public class TopicDoesNotExists extends Exception{
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

		
	public TopicDoesNotExists(String message) {
		super();
		this.message = message;
	}

	public String toString() {
		return "Topic does not Exists [ message = "+message+"]";
		
	}

}
