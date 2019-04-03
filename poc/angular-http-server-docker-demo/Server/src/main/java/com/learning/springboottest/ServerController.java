package com.learning.springboottest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboottest.domain.CustomResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
public class ServerController {

	@GetMapping("hello")
	public ResponseEntity<CustomResponse> hello() {
		System.out.println("Inside the hello method");
		CustomResponse cs = new CustomResponse();
		cs.setMessage("Hi Service is up and running");
		return new ResponseEntity<CustomResponse>(cs, HttpStatus.OK);
	}

	@GetMapping("welcome")
	public ResponseEntity<CustomResponse> welcome() {
		System.out.println("Inside the welcome method");
		CustomResponse cs = new CustomResponse();
		cs.setMessage("Hi Service is up and running");
		return new ResponseEntity<CustomResponse>(cs, HttpStatus.OK);

	}
}
