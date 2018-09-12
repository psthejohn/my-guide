package com.stackroute.qna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

/**
 * @author kumaran
 *
 */
@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private final transient QnRepository qnRepo;
	
	@Autowired
	private final transient CmtRepository cmtRepo;
	
	@Autowired
	private final transient TopicRepository topicRepo;


	
	public QnRepository getQnRepo() {
		return qnRepo;
	}


	public CmtRepository getCmtRepo() {
		return cmtRepo;
	}


	public TopicRepository getTopicRepo() {
		return topicRepo;
	}


	public QnAServiceImpl(QnRepository qnRepo, CmtRepository cmtRepo, TopicRepository topicRepo) {
		super();
		this.qnRepo = qnRepo;
		this.cmtRepo = cmtRepo;
		this.topicRepo = topicRepo;
	}
	

	@Override
	public boolean saveQuestion(Question question) throws QuestionAlreadyExists, TopicDoesNotExists {
		
		final Question questionObject = qnRepo.findByQuestionDescription(question.getQuestionDescription());
		if(questionObject != null) {
			throw new QuestionAlreadyExists("This question is already present");
		}
		int topicId = question.getTopicId();
		Topic topicObj = topicRepo.findByTopicId(topicId);
		if(topicObj == null) {
			throw new TopicDoesNotExists("Topic does not exists for this question");
		}
		qnRepo.save(question);
		return true;
	}

	@Override
	public boolean saveComment(Comment comment) throws CommentAlreadyExists, QuestionDoesNotExists {
		
		final Comment commentObject = cmtRepo.findByCommentDescription(comment.getCommentDescription());
		if(commentObject != null) {
			throw new CommentAlreadyExists("This comment is already present");
		}
		int questionId = comment.getQuestionId();
		Question questionObj = qnRepo.findByQuestionId(questionId);
		if(questionObj == null) {
			throw new QuestionDoesNotExists("Question does not exists for this comment");
		}
		cmtRepo.save(comment);
		return true;
	}

	@Override
	public boolean saveTopic(Topic topic) throws TopicAlreadyExists {
		
		final Topic topicObject = topicRepo.findByTopicName(topic.getTopicName());
		if(topicObject != null) {
			throw new TopicAlreadyExists("This Topic is already present");
		}
		topicRepo.save(topic);
		return true;
	}

	@Override
	public boolean deleteTopicById(int topicId) throws TopicDoesNotExists {
		
		final Topic topicObject = topicRepo.findByTopicId(topicId);
		if(topicObject ==  null) {
			throw new TopicDoesNotExists("Topic with this id is not present");
		}
		//qnRepo.delete();
		//qnRepo.
		topicRepo.delete(topicObject);
		return true;
	}

	@Override
	public boolean deleteQuestionById(int questionId) throws QuestionDoesNotExists {
		
		final Question questionObject = qnRepo.findByQuestionId(questionId);
		if(questionObject == null) {
			throw new QuestionDoesNotExists("Question with this id is not present");
		}
		List<Comment> li =cmtRepo.findByQuestionId(questionId);
		if(!li.isEmpty()) {
		cmtRepo.delete(li);
		}
		qnRepo.delete(questionObject);
		return true;
	}

	@Override
	public boolean deleteCommentById(int commentId) throws CommentDoesNotExists {
		
		final Comment commentObject = cmtRepo.findByCommentId(commentId);
		if(commentObject == null) {
			throw new CommentDoesNotExists("Comment with this id is not present");
		}
		if(commentObject.getCommentId() == commentId) {
		cmtRepo.delete(commentObject);
		}
		return true;
	}

	@Override
	public Topic getTopicByName(String topicName) throws TopicDoesNotExists {
		final Topic topicObject = topicRepo.findByTopicName(topicName);
		if(topicObject == null ) {
			throw new TopicDoesNotExists("Topic with this name is not present");
		}
		return topicObject;
	}

	@Override
	public Question getQuestionByQuestionDescription(String questionDescription) throws QuestionDoesNotExists {
		final Question questionObject = qnRepo.findByQuestionDescription(questionDescription);
		if(questionObject == null) {
			throw new QuestionDoesNotExists("Question with this description is not present");
		}
		return questionObject;
	}

	@Override
	public Comment getCommentByCommentDescription(String commentDescription) throws CommentDoesNotExists {
		final Comment commentObject = cmtRepo.findByCommentDescription(commentDescription);
		if(commentObject == null) {
			throw new CommentDoesNotExists("Comment with this description is not present");
			
		}
		if(commentObject.getCommentDescription().equals(commentDescription)) {
			System.out.println("both comment ids are equal");
		}
		return commentObject;
	}

	@Override
	public List<Topic> getAllTopics() {
		
			List<Topic> topicList = topicRepo.findAll();
		return topicList;
	}

	@Override
	public List<Question> getAllQuestions(int topicId) {
		
		List<Question> questionList = qnRepo.findByTopicId(topicId);
		return questionList;
	}

	@Override
	public List<Comment> getAllComments(int questionId) {
		List<Comment> commentList = cmtRepo.findByQuestionId(questionId);
		return commentList;
	}
	

}
