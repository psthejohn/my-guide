package com.stackroute.qna.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;
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

import com.stackroute.qna.model.Comment;
import com.stackroute.qna.model.Question;

import io.jsonwebtoken.lang.Collections;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional

public class QuestionRepositoryTest {

	@Autowired
	private transient QnRepository repo;
	
	@Autowired
	private transient CmtRepository cmtRepo;

	public CmtRepository getCmtRepo() {
		return cmtRepo;
	}

	public void setCmtRepo(CmtRepository cmtRepo) {
		this.cmtRepo = cmtRepo;
	}

	public QnRepository getRepo() {
		return repo;
	}

	public void setRepo(QnRepository repo) {
		this.repo = repo;
	}
	
	@Before
	public void setUp() {
		repo.deleteAll();
	}
	
	@Test
	public void testAddQuestion() throws Exception {
		
		repo.save(new Question(1,"Why ocean water is salty?",new Date(),1,"test@gmail.com"));
		final Question Question = repo.findByQuestionDescription("Why ocean water is salty?");
		assertThat(Question.getQuestionDescription().equals("Why ocean water is salty?"));
	}
	
	@Test
	public void testDeleteQuestion() throws Exception {
		cmtRepo.save(new Comment(1,"All rivers connect to the sea",new Date(),1,"test@gmail.com"));
		cmtRepo.save(new Comment(2,"Lot of minerals present inside it",new Date(),1,"test@gmail.com"));
		repo.save(new Question(1,"Why ocean water is salty?",new Date(),1,"test@gmail.com"));
		final List<Comment> comments = cmtRepo.findByQuestionId(1);
		final Question question = repo.findByQuestionDescription("Why ocean water is salty?");
		assertEquals("Why ocean water is salty?", question.getQuestionDescription());
		assertEquals("All rivers connect to the sea",comments.get(0).getCommentDescription());
		assertEquals("Lot of minerals present inside it",comments.get(1).getCommentDescription());
		cmtRepo.delete(comments);
		repo.delete(question);
		assertEquals(null,repo.findByQuestionId(1));
		assertThat(cmtRepo.findByQuestionId(1).isEmpty());
	}
	
	@Test
	public void testGetQuestionById() throws Exception {
		repo.save(new Question(1,"Why ocean water is salty?",new Date(),1,"test@gmail.com"));
		final Question Question = repo.findByQuestionDescription("Why ocean water is salty?");
		assertEquals("Why ocean water is salty?", Question.getQuestionDescription());
	}
	
	@Test
	public void testGetAllQuestions() throws Exception {
		repo.save(new Question(1,"Why ocean water is salty?",new Date(),1,"test@gmail.com"));
		//repo.save(new Question(2,"Why whales are present only in ocean?",new Date(),1));
		final List<Question> questions = repo.findAll();
		assertEquals("Why ocean water is salty?", questions.get(0).getQuestionDescription());
		//assertEquals("Why whales are present only in ocean?", questions.get(1).getQuestionDescription());
	}

}
