package com.stackroute.qna.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.stackroute.qna.model.Comment;
import com.stackroute.qna.model.Question;
import com.stackroute.qna.model.Topic;
import com.stackroute.qna.service.QnAService;


@RunWith(SpringRunner.class)
@WebMvcTest(QnAController.class)
public class QnAControllerTest {
	
	@Autowired
	private transient MockMvc mvc;
	
	@MockBean
	private transient QnAService qnaService;
	
	@InjectMocks
	private transient QnAController qnaController;
	
	private transient Topic topic;
	
	private transient Question question;
	
	private transient Comment comment;
	
	static List<Topic> topics;
	
	static List<Question> questions;
	
	static List<Comment> comments;
	
	static int topicId;
	
	static int questionId;
	
	static String token;
	
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		
		mvc = MockMvcBuilders.standaloneSetup(qnaController).build();
		topics = new ArrayList<>();
		questions = new ArrayList<>();
		comments = new ArrayList<>();
		
		topicId=1;
		questionId=1;
		
		topic = new Topic(1, "Ocean", "this describes on oceans","test@gmail.com");
		topics.add(topic);
		topic = new Topic(2,"Solar system", "this describes about solar system","test@gmail.com");
		topics.add(topic);
		
		question = new Question(1,"Why ocean water is salty",new Date(),1,"test@gmail.com");
		questions.add(question);
		question = new Question(2,"Why whales present only in ocean? ",new Date(),1,"test@gmail.com");
		questions.add(question);
		
		comment = new Comment(1,"All rivers connect to the sea",new Date(),1,"test@gmail.com");
		comments.add(comment);
		comment = new Comment(2,"Lot of minerals present inside it",new Date(),1,"test@gmail.com");
		comments.add(comment);
		
		token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTUzNDQyMDczNn0.og-whgbwO18VcUG32-0G72EoxiNGAS_ncq_Ar7YrGCw";
		
	}
	
	private String jsonToString(final Object movie) {
		String result;
		
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(movie);
			result = jsonContent;
		} catch (JsonProcessingException e) {
			result = " Processing Error";
		}
		return result;
	}
	
	@Test
	public void testSaveNewTopic() throws Exception{
		
		when(qnaService.saveTopic(topic)).thenReturn(true);
		mvc.perform(post("/v1/qna/topic").header("authorization", "Bearer "+token).contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(topic))).andExpect(status().isCreated()).andDo(print());
		verify(qnaService,times(1)).saveTopic(Mockito.any(Topic.class));
		verifyNoMoreInteractions(qnaService);
	}
	
	@Test
	public void testDeleteTopicById() throws Exception{
		when(qnaService.deleteTopicById(1)).thenReturn(true);
		mvc.perform(delete("/v1/qna/topic/{id}", 1).contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(topic))).andExpect(status().isOk());
		verify(qnaService,times(1)).deleteTopicById(1);
		verifyNoMoreInteractions(qnaService);
	}
	
	@Test
	public void testGetTopicById() throws Exception{
		when(qnaService.getTopicByName("Ocean")).thenReturn(topics.get(0));
		mvc.perform(get("/v1/qna/topic/{id}", "Ocean")).andExpect(status().isOk());
		verify(qnaService,times(1)).getTopicByName("Ocean");
		verifyNoMoreInteractions(qnaService);
	
	}
	
	@Test
	public void testGetAllTopics() throws Exception{
	
		when(qnaService.getAllTopics()).thenReturn(topics);
		mvc.perform(get("/v1/qna/topic")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
		verify(qnaService,times(1)).getAllTopics();
		verifyNoMoreInteractions(qnaService);
	}
	

	@Test
	public void testSaveNewQuestion() throws Exception{
		when(qnaService.saveQuestion(question)).thenReturn(true);
		mvc.perform(post("/v1/qna/question").header("authorization", "Bearer "+token).contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(question))).andExpect(status().isCreated()).andDo(print());
		verify(qnaService,times(1)).saveQuestion(Mockito.any(Question.class));
		verifyNoMoreInteractions(qnaService);
	}
	
	@Test
	public void testDeleteQuestionById() throws Exception{
		when(qnaService.deleteQuestionById(1)).thenReturn(true);
		mvc.perform(delete("/v1/qna/question/{id}", 1).contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(question))).andExpect(status().isOk());
		verify(qnaService,times(1)).deleteQuestionById(1);
		verifyNoMoreInteractions(qnaService);
	}
	
	@Test
	public void testGetQuestionById() throws Exception{
		when(qnaService.getQuestionByQuestionDescription("Why ocean water is salty?")).thenReturn(questions.get(0));
		mvc.perform(get("/v1/qna/question/{id}", "Why ocean water is salty")).andExpect(status().isOk());
		verify(qnaService,times(1)).getQuestionByQuestionDescription("Why ocean water is salty?");
		verifyNoMoreInteractions(qnaService);
	
	}
	
	@Test
	public void testGetAllQuestions() throws Exception{
	
		when(qnaService.getAllQuestions(topicId)).thenReturn(questions);
		mvc.perform(get("/v1/qna/questionsintopic/{id}",1)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
		verify(qnaService,times(1)).getAllQuestions(topicId);
		verifyNoMoreInteractions(qnaService);
	}
	

	@Test
	public void testSaveNewComment() throws Exception{
		when(qnaService.saveComment(comment)).thenReturn(true);
		mvc.perform(post("/v1/qna/comment").header("authorization", "Bearer "+token).contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(comment))).andExpect(status().isCreated()).andDo(print());
		verify(qnaService,times(1)).saveComment(Mockito.any(Comment.class));
		verifyNoMoreInteractions(qnaService);
	}
	
	@Test
	public void testDeleteCommentById() throws Exception{
		when(qnaService.deleteCommentById(1)).thenReturn(true);
		mvc.perform(delete("/v1/qna/comment/{id}", 1).contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(comment))).andExpect(status().isOk());
		verify(qnaService,times(1)).deleteCommentById(1);
		verifyNoMoreInteractions(qnaService);
	}
	
	@Test
	public void testGetCommentById() throws Exception{
		when(qnaService.getCommentByCommentDescription("All rivers connect to the sea")).thenReturn(comments.get(0));
		mvc.perform(get("/v1/qna/comment/{id}", "All rivers connect to the sea")).andExpect(status().isOk());
		verify(qnaService,times(1)).getCommentByCommentDescription("All rivers connect to the sea");
		verifyNoMoreInteractions(qnaService);
	
	}
	
	
	@Test
	public void testGetAllComments() throws Exception{
	
		when(qnaService.getAllComments(questionId)).thenReturn(comments);
		mvc.perform(get("/v1/qna/commentsinquestion/{id}",1)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
		verify(qnaService,times(1)).getAllComments(questionId);
		verifyNoMoreInteractions(qnaService);
	}
	
	
}
