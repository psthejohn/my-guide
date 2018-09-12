/*
 * 
 */
package com.stackroute.foodieapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * The Class ReviewEntity.
 */
@Entity(name = "Review")
@Table(name = "Review")
public class ReviewEntity {
	
	
	
	public ReviewEntity() {
		super();
	}

	/** The rating text. */
	@Column(name = "RATING_TEXT")
	private String rating_text;

	/** The id. */
	@Id
	private String reviewId;

	/** The comments count. */
	@Column(name = "comments_count")
	private String comments_count;

	/** The rating color. */
	@Column(name = "rating_color")
	private String rating_color;

	/** The likes. */
	@Column(name = "likes")
	private String likes;

	/** The rating. */
	@Column(name = "rating")
	private String rating;

	/** The review text. */
	@Column(name = "review_text")
	private String review_text;

	/** The review time friendly. */
	@Column(name = "review_time_friendly")
	private String review_time_friendly;


	/**
	 * Gets the rating text.
	 *
	 * @return the rating text
	 */
	public String getRating_text() {
		return rating_text;
	}

	/**
	 * Sets the rating text.
	 *
	 * @param rating_text the new rating text
	 */
	public void setRating_text(String rating_text) {
		this.rating_text = rating_text;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return reviewId;
	}

	/**
	 * Sets the id.
	 *
	 * @param reviewId the new id
	 */
	public void setId(String reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * Gets the comments count.
	 *
	 * @return the comments count
	 */
	public String getComments_count() {
		return comments_count;
	}

	/**
	 * Sets the comments count.
	 *
	 * @param comments_count the new comments count
	 */
	public void setComments_count(String comments_count) {
		this.comments_count = comments_count;
	}

	/**
	 * Gets the rating color.
	 *
	 * @return the rating color
	 */
	public String getRating_color() {
		return rating_color;
	}

	/**
	 * Sets the rating color.
	 *
	 * @param rating_color the new rating color
	 */
	public void setRating_color(String rating_color) {
		this.rating_color = rating_color;
	}

	/**
	 * Gets the likes.
	 *
	 * @return the likes
	 */
	public String getLikes() {
		return likes;
	}

	/**
	 * Sets the likes.
	 *
	 * @param likes the new likes
	 */
	public void setLikes(String likes) {
		this.likes = likes;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Gets the review text.
	 *
	 * @return the review text
	 */
	public String getReview_text() {
		return review_text;
	}

	/**
	 * Sets the review text.
	 *
	 * @param review_text the new review text
	 */
	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}

	/**
	 * Gets the review time friendly.
	 *
	 * @return the review time friendly
	 */
	public String getReview_time_friendly() {
		return review_time_friendly;
	}

	/**
	 * Sets the review time friendly.
	 *
	 * @param review_time_friendly the new review time friendly
	 */
	public void setReview_time_friendly(String review_time_friendly) {
		this.review_time_friendly = review_time_friendly;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReviewEntity [rating_text=" + rating_text + ", id=" + reviewId
				+ ", comments_count=" + comments_count + ", rating_color="
				+ rating_color + ", likes=" + likes + ", rating=" + rating
				+ ", review_text=" + review_text + ", review_time_friendly="
				+ review_time_friendly + "]";
	}


}
