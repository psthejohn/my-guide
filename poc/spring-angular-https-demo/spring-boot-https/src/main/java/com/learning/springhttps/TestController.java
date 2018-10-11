package com.learning.springhttps;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class TestController {

	@GetMapping("/")
	public String hello() {
		return "The application is working ";
	}

	@GetMapping("home")
	public ResponseEntity<?> home() {
		return new ResponseEntity<String>("The application is working ", HttpStatus.OK);
	}

}
