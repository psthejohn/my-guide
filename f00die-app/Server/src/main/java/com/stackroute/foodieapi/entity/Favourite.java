/*
 * 
 */
package com.stackroute.foodieapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class Favourite.
 */
@Entity(name = "Favourite")
@Table(name = "Favourite")
public class Favourite {
	
	/**
	 * Instantiates a new favourite.
	 */
	public Favourite() {
		super();
	}

	
	/** The descriptions. */
	@Column(name = "DESCIPTIONS")
	private String descriptions;

	/** The ratings. */
	@Column(name = "RATINGS")
	private String ratings;

	/** The votes. */
	@Column(name = "VOTES")
	private String votes;

	/** The currency. */
	@Column(name = "CURRENCY")
	private String currency;
	
	/** The image URL. */
	@Column(name = "IMAGE_URL")
	private String imageURL;
	/**
	 * Instantiates a new favourite.
	 *
	 * @param resId the res id
	 * @param name the name
	 * @param address the address
	 * @param costOfTwo the cost of two
	 * @param descriptions the descriptions
	 * @param ratings the ratings
	 * @param votes the votes
	 * @param imageURL the image URL
	 * @param currency the currency
	 */
	public Favourite(Long resId, String name, String address, String costOfTwo,
			String descriptions, String ratings, String votes,String imageURL,String currency) {
		super();
		// this.resId = resId;
		this.name = name;
		this.address = address;
		this.costOfTwo = costOfTwo;
		this.descriptions = descriptions;
		this.ratings = ratings;
		this.votes = votes;
		this.imageURL = imageURL;
		this.currency = currency;
	}

	/** The id. */
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private String favId;

	/*
	 * @Column(name = "RES_ID") private Long resId;
	 */

	/** The name. */
	@Column(name = "NAME")
	private String name;

	/** The address. */
	@Column(name = "ADDRESS")
	private String address;

	/** The cost of two. */
	@Column(name = "COST_OF_TWO")
	private String costOfTwo;

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/*
	 * public Long getResId() { return resId; }
	 * 
	 * public void setResId(Long resId) { this.resId = resId; }
	 */

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return favId;
	}

	/**
	 * Sets the cost of two.
	 *
	 * @param costOfTwo the new cost of two
	 */
	public void setCostOfTwo(String costOfTwo) {
		this.costOfTwo = costOfTwo;
	}

	/**
	 * Sets the id.
	 *
	 * @param favId the new id
	 */
	public void setId(String favId) {
		this.favId = favId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the cost of two.
	 *
	 * @return the cost of two
	 */
	public String getCostOfTwo() {
		return costOfTwo;
	}

	/**
	 * Gets the descriptions.
	 *
	 * @return the descriptions
	 */
	public String getDescriptions() {
		return descriptions;
	}

	/**
	 * Sets the descriptions.
	 *
	 * @param descriptions the new descriptions
	 */
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * Gets the ratings.
	 *
	 * @return the ratings
	 */
	public String getRatings() {
		return ratings;
	}

	/**
	 * Sets the ratings.
	 *
	 * @param ratings the new ratings
	 */
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	/**
	 * Gets the votes.
	 *
	 * @return the votes
	 */
	public String getVotes() {
		return votes;
	}

	/**
	 * Sets the votes.
	 *
	 * @param votes the new votes
	 */
	public void setVotes(String votes) {
		this.votes = votes;
	}

	/**
	 * Gets the image URL.
	 *
	 * @return the image URL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * Sets the image URL.
	 *
	 * @param imageURL the new image URL
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

}
