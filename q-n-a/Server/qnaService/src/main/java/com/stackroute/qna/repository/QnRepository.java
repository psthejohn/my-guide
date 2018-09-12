package com.stackroute.qna.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.qna.model.Question;



public interface QnRepository extends JpaRepository<Question, Integer> {
	
	Question findByQuestionDescription(String questionDescription);

	Question findByQuestionId(int questionId);
	
	List<Question> findByTopicId(int topicId);
}
