package com.stackroute.qna.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.qna.model.Topic;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional

public class TopicRepositoryTest {
	
	@Autowired
	private transient TopicRepository repo;

	public TopicRepository getRepo() {
		return repo;
	}

	public void setRepo(TopicRepository repo) {
		this.repo = repo;
	}
	

	@Before
	public void setUp() {
		repo.deleteAll();
	}
	
	@Test
	public void testAddTopic() throws Exception {
		
		repo.save(new Topic(1,"Oceans","This describes about water and ocean","test@gmail.com"));
		final Topic topic = repo.findByTopicName("Oceans");
		assertThat(topic.getTopicName().equals("Oceans"));
	}
	
	@Test
	public void testDeleteTopic() throws Exception {
		
		repo.save(new Topic(1,"Oceans","This describes about water and ocean","test@gmail.com"));
		final Topic topic = repo.findByTopicName("Oceans");
		assertEquals("Oceans", topic.getTopicName());
		repo.delete(topic);
		assertEquals(null,repo.findByTopicName("Oceans"));
	}
	
	@Test
	public void testGetTopicById() throws Exception {
		repo.save(new Topic(1,"Oceans","This describes about water and ocean","test@gmail.com"));
		final Topic topic = repo.findByTopicName("Oceans");
		assertEquals("Oceans", topic.getTopicName());
	}
	
	@Test
	public void testGetAllTopics() throws Exception {
		repo.save(new Topic(1,"Oceans","This describes about water and ocean","test@gmail.com"));
		repo.save(new Topic(2,"Solar system","This describes about sun and planets","test@gmail.com"));
		final List<Topic> topics = repo.findAll();
		assertEquals("Oceans", topics.get(0).getTopicName());
		assertEquals("Solar system", topics.get(1).getTopicName());
	}

}
