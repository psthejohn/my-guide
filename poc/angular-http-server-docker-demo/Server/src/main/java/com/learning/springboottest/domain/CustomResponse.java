package com.learning.springboottest.domain;

import org.springframework.http.HttpStatus;

public class CustomResponse {

	private String message;
	private HttpStatus responseStatus;
	private Object obj;

	public CustomResponse() {

	}

	public CustomResponse(String message, HttpStatus responseStatus, Object obj) {
		super();
		this.message = message;
		this.responseStatus = responseStatus;
		this.obj = obj;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(HttpStatus ok) {
		this.responseStatus = ok;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "CustomResponse [message=" + message + ", responseStatus=" + responseStatus + ", obj=" + obj + "]";
	}

}
