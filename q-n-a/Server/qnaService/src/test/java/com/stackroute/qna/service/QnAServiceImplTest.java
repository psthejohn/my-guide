package com.stackroute.qna.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.qna.exception.CommentAlreadyExists;
import com.stackroute.qna.exception.CommentDoesNotExists;
import com.stackroute.qna.exception.QuestionAlreadyExists;
import com.stackroute.qna.exception.QuestionDoesNotExists;
import com.stackroute.qna.exception.TopicAlreadyExists;
import com.stackroute.qna.exception.TopicDoesNotExists;
import com.stackroute.qna.model.Comment;
import com.stackroute.qna.model.Question;
import com.stackroute.qna.model.Topic;
import com.stackroute.qna.repository.CmtRepository;
import com.stackroute.qna.repository.QnRepository;
import com.stackroute.qna.repository.TopicRepository;


public class QnAServiceImplTest {

	@Mock
	private transient TopicRepository topicRepo;
	
	@Mock
	private transient QnRepository qnRepo;
	
	@Mock
	private transient CmtRepository cmtRepo;
	
	private transient Topic topic;
	
	private transient Question question;
	
	private transient Comment comment;
	
	@InjectMocks
	private transient QnAServiceImpl qnaServiceImpl;
	
	transient Optional<Topic> topicOptions;
	
	transient Optional<Question> qnOptions;
	
	transient Optional<Comment> cmtOptions;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		topic = new Topic(1,"Ocean","This topic discuss about ocean","test@gmail.com");
		question = new Question(1,"Why ocean is salty?",new Date(),1,"test@gmail.com");
		comment = new Comment(1,"Because it contains minerals",new Date(),1,"test@gmail.com");
		
		topicOptions= Optional.of(topic);
		qnOptions = Optional.of(question);
		cmtOptions = Optional.of(comment);
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull("jpaRepository createion fails: use @InjectMocks onTopic QnAServiceImpl"
				,topic);
		assertNotNull("jpaRepository createion fails: use @InjectMocks onQuestion QnAServiceImpl"
				,question);
		assertNotNull("jpaRepository createion fails: use @InjectMocks onComment QnAServiceImpl"
				,comment);
	}
	
	@Test
	public void testAddTopic() throws TopicAlreadyExists {
		when(topicRepo.save(topic)).thenReturn(topic);
		final boolean isTopicSaved = qnaServiceImpl.saveTopic(topic);
		assertTrue("The topic is not saved", isTopicSaved);
		verify(topicRepo,times(1)).save(topic);
	}
	
	@Test
	public void testDeleteTopic() throws TopicDoesNotExists {
		when(topicRepo.findByTopicId(1)).thenReturn(topic);
		doNothing().when(topicRepo).delete(topic);
		boolean isTopicDeleted = qnaServiceImpl.deleteTopicById(1);
		assertTrue("The deletion of topic failed",isTopicDeleted);
		verify(topicRepo,times(1)).findByTopicId(1);
		verify(topicRepo,times(1)).delete(topic);
	}
	
	@Test
	public void testGetTopic() throws TopicDoesNotExists {
		when(topicRepo.findByTopicName("Ocean")).thenReturn(topic);
		final Topic topicObject = qnaServiceImpl.getTopicByName("Ocean");
		assertEquals("The topic does not exists", "Ocean",topicObject.getTopicName());
		verify(topicRepo,times(1)).findByTopicName("Ocean");
	}
	
	@Test
	public void testGetAllTopics() {
		List<Topic> topicList = new ArrayList<>(1);
		when(topicRepo.findAll()).thenReturn(topicList);
		List<Topic> tList = qnaServiceImpl.getAllTopics();
		assertEquals(topicList, tList);
	}
	
	@Test
	public void testAddQuestion() throws QuestionAlreadyExists, TopicDoesNotExists {
		when(topicRepo.findByTopicId(1)).thenReturn(topic);
		when(qnRepo.save(question)).thenReturn(question);
		final boolean isQuestionSaved = qnaServiceImpl.saveQuestion(question);
		assertTrue("The question is not saved", isQuestionSaved);
		verify(qnRepo,times(1)).save(question);
	}
	
	@Test
	public void testDeleteQuestion() throws QuestionDoesNotExists {
		when(qnRepo.findByQuestionId(1)).thenReturn(question);
		doNothing().when(qnRepo).delete(question);
		boolean isQuestionDeleted = qnaServiceImpl.deleteQuestionById(1);
		assertTrue("The deletion of question failed",isQuestionDeleted);
		verify(qnRepo,times(1)).findByQuestionId(1);
		verify(qnRepo,times(1)).delete(question);
	}
	
	@Test
	public void testGetQuestion() throws QuestionDoesNotExists {
		when(qnRepo.findByQuestionDescription("Why ocean is salty?")).thenReturn(question);
		final Question questionObject = qnaServiceImpl.getQuestionByQuestionDescription("Why ocean is salty?");
		assertEquals("The question does not exists", "Why ocean is salty?",questionObject.getQuestionDescription());
		verify(qnRepo,times(1)).findByQuestionDescription("Why ocean is salty?");
	}
	
	@Test
	public void testGetAllQuestions() {
		List<Question> questionList = new ArrayList<>(1);
		when(qnRepo.findByTopicId(1)).thenReturn(questionList);
		List<Question> tList = qnaServiceImpl.getAllQuestions(1);
		assertEquals(questionList, tList);
	}
	
	@Test
	public void testAddComment() throws CommentAlreadyExists, QuestionDoesNotExists {
		when(qnRepo.findByQuestionId(1)).thenReturn(question);
		when(cmtRepo.save(comment)).thenReturn(comment);
		final boolean isCommentSaved = qnaServiceImpl.saveComment(comment);
		assertTrue("The comment is not saved", isCommentSaved);
		verify(cmtRepo,times(1)).save(comment);
	}
	
	@Test
	public void testDeleteComment() throws CommentDoesNotExists {
		when(cmtRepo.findByCommentId(1)).thenReturn(comment);
		doNothing().when(cmtRepo).delete(comment);
		boolean isCommentDeleted = qnaServiceImpl.deleteCommentById(1);
		assertTrue("The deletion of comment failed",isCommentDeleted);
		verify(cmtRepo,times(1)).findByCommentId(1);
		verify(cmtRepo,times(1)).delete(comment);
	}
	
	@Test
	public void testGetComment() throws CommentDoesNotExists {
		when(cmtRepo.findByCommentDescription("All rivers connect to the sea")).thenReturn(comment);
		final Comment commentObject = qnaServiceImpl.getCommentByCommentDescription("All rivers connect to the sea");
		assertEquals("The comment does not exists", "Because it contains minerals",commentObject.getCommentDescription());
		verify(cmtRepo,times(1)).findByCommentDescription("All rivers connect to the sea");
	}
	
	@Test
	public void testGetAllComments() {
		List<Comment> commentList = new ArrayList<>(1);
		when(cmtRepo.findAll()).thenReturn(commentList);
		List<Comment> tList = qnaServiceImpl.getAllComments(1);
		assertEquals(commentList, tList);
	}	
	
}
