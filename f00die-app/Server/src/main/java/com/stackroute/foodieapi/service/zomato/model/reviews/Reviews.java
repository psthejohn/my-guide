package com.stackroute.foodieapi.service.zomato.model.reviews;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reviews
{
    public Reviews() {
		super();
	}

	private String reviews_shown;

    private String reviews_start;

    private String reviews_count;

    @JsonProperty("user_reviews")
    private UserReviews[] user_reviews;

    private String RespondToReviewsViaZomatoDashboard;

    public String getReviews_shown ()
    {
        return reviews_shown;
    }

    public void setReviews_shown (String reviews_shown)
    {
        this.reviews_shown = reviews_shown;
    }

    public String getReviews_start ()
    {
        return reviews_start;
    }

    public void setReviews_start (String reviews_start)
    {
        this.reviews_start = reviews_start;
    }

    public String getReviews_count ()
    {
        return reviews_count;
    }

    public void setReviews_count (String reviews_count)
    {
        this.reviews_count = reviews_count;
    }

	public UserReviews[] getUser_reviews() {
		return user_reviews;
	}

	public void setUser_reviews(UserReviews[] user_reviews) {
		this.user_reviews = user_reviews;
	}

	public String getRespondToReviewsViaZomatoDashboard() {
		return RespondToReviewsViaZomatoDashboard;
	}

	public void setRespondToReviewsViaZomatoDashboard(
			String respondToReviewsViaZomatoDashboard) {
		RespondToReviewsViaZomatoDashboard = respondToReviewsViaZomatoDashboard;
	}

	@Override
	public String toString() {
		return "Reviews [reviews_shown=" + reviews_shown + ", reviews_start="
				+ reviews_start + ", reviews_count=" + reviews_count
				+ ", RespondToReviewsViaZomatoDashboard="
				+ RespondToReviewsViaZomatoDashboard + "]";
	}

   

    
}
	
