package com.learning.springbootwebsocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class WebSocketController {

	private final SimpMessagingTemplate template;

	@Autowired
	WebSocketController(SimpMessagingTemplate template) {
		this.template = template;
	}

	@GetMapping("hi")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<String>("Hi its working", HttpStatus.OK);
	}

	// endpoint for acccepting the messages coming from frontend and will send them
	// back to topic "/chat"
	@MessageMapping("/message")
	public void onReceiveMessage(String message) throws Exception {
		System.out.println("data incoming is " + message);
		this.template.convertAndSend("/chat", message);
	}
}
