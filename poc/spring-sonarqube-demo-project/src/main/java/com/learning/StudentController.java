package com.learning;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.domain.Student;

@RestController
@RequestMapping("api/v1")
public class StudentController {

	@GetMapping("home")
	public String hello() {
		return "Hi service is up and working";
	}

	@GetMapping("data")
	public ResponseEntity<Student> getData() {
		Student st = new Student(1, "aayush", "btm");
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}

}
