package com.stackroute.foodieapi.dao;

import org.springframework.stereotype.Repository;

import com.stackroute.foodieapi.entity.ReviewEntity;


/**
 * The Interface ReviewsDAO.
 */
@Repository
public interface ReviewsDAO {
	
	/**
	 * Creates the.
	 *
	 * @param reviewEntity the review entity
	 * @return the review entity
	 */
	ReviewEntity create(ReviewEntity reviewEntity);

	/**
	 * Update.
	 *
	 * @param reviewEntity the review entity
	 * @return the review entity
	 */
	ReviewEntity update(ReviewEntity reviewEntity);

	/**
	 * Gets the.
	 *
	 * @param reviewId the id
	 * @return the review entity
	 */
	ReviewEntity get(String reviewId);

}
