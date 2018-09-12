package com.stackroute.foodieapi.service.zomato.model.restaurantscuisines;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "results_found", "results_start", "results_shown",
		"restaurants" })
public class RestaurantsCuisines {
	
	public RestaurantsCuisines() {
		super();
	}

	private String error;

	private String errorCode;
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@JsonProperty("results_found")
	private Integer results_found;
	@JsonProperty("results_start")
	private Integer results_start;
	@JsonProperty("results_shown")
	private Integer results_shown;
	@JsonProperty("restaurants")
	private List<Restaurant> restaurants = null;

	@JsonProperty("results_found")
	public Integer getResults_found() {
		return results_found;
	}

	@JsonProperty("results_found")
	public void setResults_found(Integer results_found) {
		this.results_found = results_found;
	}

	@JsonProperty("results_start")
	public Integer getResults_start() {
		return results_start;
	}

	@JsonProperty("results_start")
	public void setResults_start(Integer results_start) {
		this.results_start = results_start;
	}

	@JsonProperty("results_shown")
	public Integer getResults_shown() {
		return results_shown;
	}

	@JsonProperty("results_shown")
	public void setResults_shown(Integer results_shown) {
		this.results_shown = results_shown;
	}

	@JsonProperty("restaurants")
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	@JsonProperty("restaurants")
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

}
