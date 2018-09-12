/*
 * 
 */
package com.stackroute.foodieapi.service.zomato.model.restaurant;

import com.fasterxml.jackson.annotation.JsonTypeName;



/**
 * The Class UserRating.
 */
@JsonTypeName(value = "user_rating")
public class UserRating
{
    
    public UserRating() {
		super();
	}

	/** The rating text. */
    private String rating_text;

    /** The rating color. */
    private String rating_color;

    /** The votes. */
    private String votes;

    /** The aggregate rating. */
    private String aggregate_rating;

    /**
     * Gets the rating text.
     *
     * @return the rating text
     */
    public String getRating_text ()
    {
        return rating_text;
    }

    /**
     * Sets the rating text.
     *
     * @param rating_text the new rating text
     */
    public void setRating_text (String rating_text)
    {
        this.rating_text = rating_text;
    }

    /**
     * Gets the rating color.
     *
     * @return the rating color
     */
    public String getRating_color ()
    {
        return rating_color;
    }

    /**
     * Sets the rating color.
     *
     * @param rating_color the new rating color
     */
    public void setRating_color (String rating_color)
    {
        this.rating_color = rating_color;
    }

    /**
     * Gets the votes.
     *
     * @return the votes
     */
    public String getVotes ()
    {
        return votes;
    }

    /**
     * Sets the votes.
     *
     * @param votes the new votes
     */
    public void setVotes (String votes)
    {
        this.votes = votes;
    }

    /**
     * Gets the aggregate rating.
     *
     * @return the aggregate rating
     */
    public String getAggregate_rating ()
    {
        return aggregate_rating;
    }

    /**
     * Sets the aggregate rating.
     *
     * @param aggregate_rating the new aggregate rating
     */
    public void setAggregate_rating (String aggregate_rating)
    {
        this.aggregate_rating = aggregate_rating;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "ClassPojo [rating_text = "+rating_text+", rating_color = "+rating_color+", votes = "+votes+", aggregate_rating = "+aggregate_rating+"]";
    }
}

