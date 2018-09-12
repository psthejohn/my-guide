package com.stackroute.qna.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.qna.model.Comment;

public interface CmtRepository extends JpaRepository<Comment, Integer>{

	Comment findByCommentDescription(String commentDescription);

	Comment findByCommentId(int commentId);
	
	List<Comment> findByQuestionId(int questionId);
}
