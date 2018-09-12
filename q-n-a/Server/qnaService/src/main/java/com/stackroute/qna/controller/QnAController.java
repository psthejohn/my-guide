package com.stackroute.qna.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.stackroute.qna.exception.CommentDoesNotExists;
import com.stackroute.qna.exception.QuestionDoesNotExists;
import com.stackroute.qna.exception.TopicDoesNotExists;
import com.stackroute.qna.model.Comment;
import com.stackroute.qna.model.Question;
import com.stackroute.qna.model.Topic;
import com.stackroute.qna.service.QnAService;

import io.jsonwebtoken.Jwts;

@CrossOrigin

@RestController
@RequestMapping(path = "/v1/qna")
public class QnAController {
	
	private QnAService qnaService;

	@Autowired
	public QnAController(QnAService qnaService) {
		super();
		this.qnaService = qnaService;
	}
	
	@PostMapping(path = "/topic")
	public ResponseEntity<?> saveTopic(@RequestBody final Topic topic, HttpServletRequest 
			request, HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token)
				.getBody().getSubject();
		
		ResponseEntity<?> responseEntity;
		
		try {
		topic.setUserId(userId);
		qnaService.saveTopic(topic);
		responseEntity = new ResponseEntity<Topic>(topic, HttpStatus.CREATED);
		}
		catch(Exception e) {
			responseEntity = new ResponseEntity<String>("{\"message\": \""+e.getMessage()
			+"\"}", HttpStatus.CONFLICT);
		}
		
		return responseEntity;
	}
	
	@PostMapping(path = "/question")
	public ResponseEntity<?> saveQuestion(@RequestBody final Question question, HttpServletRequest 
			request, HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token)
				.getBody().getSubject();
		
		ResponseEntity<?> responseEntity;
		
		try {
		question.setUserId(userId);
		qnaService.saveQuestion(question);
		responseEntity = new ResponseEntity<Question>(question, HttpStatus.CREATED);
		}
		catch(Exception e) {
			responseEntity = new ResponseEntity<String>("{\"message\": \""+e.getMessage()
			+"\"}", HttpStatus.CONFLICT);
		}
		
		return responseEntity;
	}
	
	@PostMapping(path = "/comment")
	public ResponseEntity<?> saveComment(@RequestBody final Comment comment, HttpServletRequest 
			request, HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token)
				.getBody().getSubject();
		
		ResponseEntity<?> responseEntity;
		
		try {
		comment.setUserId(userId);
		qnaService.saveComment(comment);
		responseEntity = new ResponseEntity<Comment>(comment, HttpStatus.CREATED);
		}
		catch(Exception e) {
			responseEntity = new ResponseEntity<String>("{\"message\": \""+e.getMessage()
			+"\"}", HttpStatus.CONFLICT);
		}
		
		return responseEntity;
	}

	@DeleteMapping(value = "/topic/{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable("id") final Integer topicId){
		
		ResponseEntity<?> responseEntity;
		
		try {
			qnaService.deleteTopicById(topicId);
			responseEntity = new ResponseEntity<String>(" Topic deleted successfully "
					, HttpStatus.OK);
		} catch (TopicDoesNotExists e) {
			responseEntity = new ResponseEntity<String>("{\"message\": \""+e.getMessage()
			+"\"}", HttpStatus.NOT_FOUND);
		}
		
		
		return responseEntity;
	}
	
	@DeleteMapping(value = "/question/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable("id") final Integer questionId){
		
		ResponseEntity<?> responseEntity;
		
		try {
			qnaService.deleteQuestionById(questionId);
			responseEntity = new ResponseEntity<String>(" Question deleted successfully "
					, HttpStatus.OK);
		} catch (QuestionDoesNotExists e) {
			responseEntity = new ResponseEntity<String>("{\"message\": \""+e.getMessage()
			+"\"}", HttpStatus.NOT_FOUND);
		}
		
		
		return responseEntity;
	}
	
	@DeleteMapping(value = "/comment/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable("id") final Integer commentId){
		
		ResponseEntity<?> responseEntity;
		
		try {
			qnaService.deleteCommentById(commentId);
			responseEntity = new ResponseEntity<String>(" Comment deleted successfully "
					, HttpStatus.OK);
			
		} catch (CommentDoesNotExists e) {
			responseEntity = new ResponseEntity<String>("{\"message\": \""+e.getMessage()
			+"\"}", HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
	}
	
	@GetMapping(value = "/topic/{topicName}")
	public ResponseEntity<?> getTopic(@PathVariable("topicName") final String topicName){
		ResponseEntity<?> responseEntity;
		Topic topicObject = null;
		try {
			topicObject = qnaService.getTopicByName(topicName);
		}catch (TopicDoesNotExists e) {
			responseEntity = new ResponseEntity<String>("{\"message\": \""+e.getMessage()
			+"\"}", HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<Topic>(topicObject,HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping(value = "/question/{questionDescription}")
	public ResponseEntity<?> getQuestion(@PathVariable("questionDescription") final String questionDescription){
		ResponseEntity<?> responseEntity;
		Question questionObject = null;
		try {
			System.out.println("Question description = "+questionDescription);
			questionObject = qnaService.getQuestionByQuestionDescription(questionDescription+"?");
		}catch(QuestionDoesNotExists e) {
			responseEntity = new ResponseEntity<String>("{\"message\": \""+e.getMessage()
			+"\"}", HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<Question>(questionObject,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value = "/comment/{commentDescription}")
	public ResponseEntity<?> getComment(@PathVariable("commentDescription") final String commentDescription){
		ResponseEntity<?> responseEntity;
		Comment commentObject = null;
		try {
			commentObject = qnaService.getCommentByCommentDescription(commentDescription);
		}catch(CommentDoesNotExists e) {
			responseEntity = new ResponseEntity<String>("{\"message\": \""+e.getMessage()
			+"\"}", HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<Comment>(commentObject,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value ="/topic")
	public ResponseEntity<List<Topic>> getAllTopics(){
		List<Topic> topicList = qnaService.getAllTopics();
		ResponseEntity<List<Topic>> responseEntity = new ResponseEntity<List<Topic>>(topicList,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value ="/questionsintopic/{id}")
	public ResponseEntity<List<Question>> getAllQuestions(@PathVariable("id") final Integer TopicId){
		List<Question> questionList = qnaService.getAllQuestions(TopicId);
		ResponseEntity<List<Question>> responseEntity = new ResponseEntity<List<Question>>(questionList,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value ="/commentsinquestion/{id}")
	public ResponseEntity<List<Comment>> getAllComments(@PathVariable("id") final Integer questionId){
		List<Comment> commentList = qnaService.getAllComments(questionId);
		ResponseEntity<List<Comment>> responseEntity = new ResponseEntity<List<Comment>>(commentList,HttpStatus.OK);
		return responseEntity;
	}
}
