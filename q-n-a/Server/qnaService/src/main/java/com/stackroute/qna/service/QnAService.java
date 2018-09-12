package com.stackroute.qna.service;

import java.util.List;

import com.stackroute.qna.exception.CommentAlreadyExists;
import com.stackroute.qna.exception.CommentDoesNotExists;
import com.stackroute.qna.exception.QuestionAlreadyExists;
import com.stackroute.qna.exception.QuestionDoesNotExists;
import com.stackroute.qna.exception.TopicAlreadyExists;
import com.stackroute.qna.exception.TopicDoesNotExists;
import com.stackroute.qna.model.Comment;
import com.stackroute.qna.model.Question;
import com.stackroute.qna.model.Topic;

public interface QnAService {
	
	boolean saveTopic(Topic topic) throws TopicAlreadyExists;

	boolean saveQuestion(Question question) throws QuestionAlreadyExists,TopicDoesNotExists;
	
	boolean saveComment(Comment comment) throws CommentAlreadyExists, QuestionDoesNotExists;
	
	boolean deleteTopicById(int topicId) throws TopicDoesNotExists;
	
	boolean deleteQuestionById(int questionId) throws QuestionDoesNotExists;
	
	boolean deleteCommentById(int commentId) throws CommentDoesNotExists;
	
	Topic getTopicByName(String topicName) throws TopicDoesNotExists;
	
	Question getQuestionByQuestionDescription(String questionDescription) throws QuestionDoesNotExists;
	
	Comment getCommentByCommentDescription(String commentDescription) throws CommentDoesNotExists;
	
	List<Topic> getAllTopics();
	
	List<Question> getAllQuestions(int topicId);
	
	List<Comment> getAllComments(int questionId);
	
}
