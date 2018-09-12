package com.stackroute.qna.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.qna.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer>{
	
	Topic findByTopicName(String topicName);
	
	Topic findByTopicId(int topicId);

}
