/*
 * 
 */
package com.stackroute.foodieapi.service.zomato.model.cuisines;

import com.fasterxml.jackson.annotation.JsonTypeName;


/**
 * The Class Cuisine.
 */
@JsonTypeName(value = "cuisine")
public class Cuisine {
	
	public Cuisine() {
		super();
	}

	/** The cuisine name. */
	private String cuisine_name;

	/** The cuisine id. */
	private String cuisine_id;

	/**
	 * Gets the cuisine name.
	 *
	 * @return the cuisine name
	 */
	public String getCuisine_name() {
		return cuisine_name;
	}

	/**
	 * Sets the cuisine name.
	 *
	 * @param cuisine_name the new cuisine name
	 */
	public void setCuisine_name(String cuisine_name) {
		this.cuisine_name = cuisine_name;
	}

	/**
	 * Gets the cuisine id.
	 *
	 * @return the cuisine id
	 */
	public String getCuisine_id() {
		return cuisine_id;
	}

	/**
	 * Sets the cuisine id.
	 *
	 * @param cuisine_id the new cuisine id
	 */
	public void setCuisine_id(String cuisine_id) {
		this.cuisine_id = cuisine_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassPojo [cuisine_name = " + cuisine_name + ", cuisine_id = "
				+ cuisine_id + "]";
	}
}
