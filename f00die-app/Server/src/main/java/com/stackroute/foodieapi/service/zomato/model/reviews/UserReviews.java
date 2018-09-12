package com.stackroute.foodieapi.service.zomato.model.reviews;


/**
 * The Class UserReviews.
 */
public class UserReviews {
	
	public UserReviews() {
		super();
	}

	/** The review. */
	private Review review;

	/**
	 * Gets the review.
	 *
	 * @return the review
	 */
	public Review getReview() {
		return review;
	}

	/**
	 * Sets the review.
	 *
	 * @param review the new review
	 */
	public void setReview(Review review) {
		this.review = review;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassPojo [review = " + review + "]";
	}

}
