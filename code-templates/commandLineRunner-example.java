package com.learning.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.learning.domain.Topic;
import com.learning.service.QnAService;

@Component
public class AppStartupRunner implements CommandLineRunner {

	@Autowired
	QnAService qnaService;

	@Override
	public void run(String... args) throws Exception {
		List<Topic> topics = this.qnaService.retreiveTopics();
		if (CollectionUtils.isEmpty(topics)) {
			Topic topic = new Topic("Angular", "Angular is a TypeScript-based open-source front-end web application platform");
			this.qnaService.saveTopic(topic);
			topic = new Topic("Python", "Python is an interpreted high-level programming language for general-purpose programming");
			this.qnaService.saveTopic(topic);
			topic = new Topic("Spring", "Spring Framework is an application framework and inversion of control container for the Java platform");
			this.qnaService.saveTopic(topic);
			topic = new Topic("Hadoop", "Hadoop is a collection of open-source software utilities that facilitate using a network of many computers to solve problems involving massive amounts of data and computation");
			this.qnaService.saveTopic(topic);
			topic = new Topic("VueJS", "Vue.js is an open-source JavaScript framework for building user interfaces");
			this.qnaService.saveTopic(topic);
		}

	}

}
