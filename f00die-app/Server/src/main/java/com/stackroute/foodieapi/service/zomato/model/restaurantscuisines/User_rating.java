package com.stackroute.foodieapi.service.zomato.model.restaurantscuisines;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "aggregate_rating", "rating_text", "rating_color", "votes" })
public class User_rating {

	public User_rating() {
		super();
	}

	@JsonProperty("aggregate_rating")
	private String aggregate_rating;
	@JsonProperty("rating_text")
	private String rating_text;
	@JsonProperty("rating_color")
	private String rating_color;
	@JsonProperty("votes")
	private String votes;

	@JsonProperty("aggregate_rating")
	public String getAggregate_rating() {
		return aggregate_rating;
	}

	@JsonProperty("aggregate_rating")
	public void setAggregate_rating(String aggregate_rating) {
		this.aggregate_rating = aggregate_rating;
	}

	@JsonProperty("rating_text")
	public String getRating_text() {
		return rating_text;
	}

	@JsonProperty("rating_text")
	public void setRating_text(String rating_text) {
		this.rating_text = rating_text;
	}

	@JsonProperty("rating_color")
	public String getRating_color() {
		return rating_color;
	}

	@JsonProperty("rating_color")
	public void setRating_color(String rating_color) {
		this.rating_color = rating_color;
	}

	@JsonProperty("votes")
	public String getVotes() {
		return votes;
	}

	@JsonProperty("votes")
	public void setVotes(String votes) {
		this.votes = votes;
	}

}