package com.stackroute.qna.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.After;
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

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional

public class CommentRepositoryTest {

	@Autowired
	private transient CmtRepository repo;

	private transient Comment commentSample;
	
	public CmtRepository getRepo() {
		return repo;
	}

	public void setRepo(CmtRepository repo) {
		this.repo = repo;
	}
	
	@Before
	public void setUp() {
		repo.deleteAll();
	}
	
	@Test
	public void testDeleteComment() throws Exception {
		
		repo.save(new Comment(1,"All rivers connect to the sea",new Date(),1,"test@gmail.com"));
		final Comment comment = repo.findByCommentDescription("All rivers connect to the sea");
		assertEquals("All rivers connect to the sea", comment.getCommentDescription());
		repo.delete(comment);
		assertEquals(null,repo.findByCommentId(1));
	}
	

	@Test
	public void testAddComment() throws Exception {
		
		//repo.save(new Comment(1,"All rivers connect to the sea",new Date(),1));
		//final Comment comment = repo.findOne(1);
		commentSample = new Comment(1,"All rivers connect to the sea",new Date(),1,"test@gmail.com");
		repo.save(commentSample);
		final Comment comment1 = repo.findByCommentDescription("All rivers connect to the sea");
		assertThat(comment1.getCommentDescription().equals("All rivers connect to the sea"));
	}
	
	
	
	@Test
	public void testGetCommentById() throws Exception {
		repo.save(new Comment(1,"All rivers connect to the sea",new Date(),1,"test@gmail.com"));
		final Comment comment = repo.findByCommentDescription("All rivers connect to the sea");
		assertEquals("All rivers connect to the sea", comment.getCommentDescription());
	}
	
	@Test
	public void testGetAllComments() throws Exception {
		repo.save(new Comment(1,"All rivers connect to the sea",new Date(),1,"test@gmail.com"));
		//repo.save(new Comment(2,"Lot of minerals present inside it",new Date(),1));
		final List<Comment> comments = repo.findAll();
		
		assertEquals("All rivers connect to the sea", comments.get(0).getCommentDescription());
		//assertEquals("Lot of minerals present inside it", comments.get(1).getCommentDescription());
	}
	
}
