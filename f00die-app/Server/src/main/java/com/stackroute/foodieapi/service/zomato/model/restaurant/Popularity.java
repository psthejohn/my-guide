package com.stackroute.foodieapi.service.zomato.model.restaurant;


/**
 * The Class Popularity.
 */
public class Popularity {
	
	public Popularity() {
		super();
	}

	/** The nearby res. */
	private String[] nearby_res;

	/** The subzone. */
	private String subzone;

	/** The top cuisines. */
	private String[] top_cuisines;

	/** The subzone id. */
	private String subzone_id;

	/** The nightlife res. */
	private String nightlife_res;

	/** The nightlife index. */
	private String nightlife_index;

	/** The city. */
	private String city;

	/** The popularity res. */
	private String popularity_res;

	/** The popularity. */
	private String popularity;

	/**
	 * Gets the nearby res.
	 *
	 * @return the nearby res
	 */
	public String[] getNearby_res() {
		return nearby_res;
	}

	/**
	 * Sets the nearby res.
	 *
	 * @param nearby_res the new nearby res
	 */
	public void setNearby_res(String[] nearby_res) {
		this.nearby_res = nearby_res;
	}

	/**
	 * Gets the subzone.
	 *
	 * @return the subzone
	 */
	public String getSubzone() {
		return subzone;
	}

	/**
	 * Sets the subzone.
	 *
	 * @param subzone the new subzone
	 */
	public void setSubzone(String subzone) {
		this.subzone = subzone;
	}

	/**
	 * Gets the top cuisines.
	 *
	 * @return the top cuisines
	 */
	public String[] getTop_cuisines() {
		return top_cuisines;
	}

	/**
	 * Sets the top cuisines.
	 *
	 * @param top_cuisines the new top cuisines
	 */
	public void setTop_cuisines(String[] top_cuisines) {
		this.top_cuisines = top_cuisines;
	}

	/**
	 * Gets the subzone id.
	 *
	 * @return the subzone id
	 */
	public String getSubzone_id() {
		return subzone_id;
	}

	/**
	 * Sets the subzone id.
	 *
	 * @param subzone_id the new subzone id
	 */
	public void setSubzone_id(String subzone_id) {
		this.subzone_id = subzone_id;
	}

	/**
	 * Gets the nightlife res.
	 *
	 * @return the nightlife res
	 */
	public String getNightlife_res() {
		return nightlife_res;
	}

	/**
	 * Sets the nightlife res.
	 *
	 * @param nightlife_res the new nightlife res
	 */
	public void setNightlife_res(String nightlife_res) {
		this.nightlife_res = nightlife_res;
	}

	/**
	 * Gets the nightlife index.
	 *
	 * @return the nightlife index
	 */
	public String getNightlife_index() {
		return nightlife_index;
	}

	/**
	 * Sets the nightlife index.
	 *
	 * @param nightlife_index the new nightlife index
	 */
	public void setNightlife_index(String nightlife_index) {
		this.nightlife_index = nightlife_index;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the popularity res.
	 *
	 * @return the popularity res
	 */
	public String getPopularity_res() {
		return popularity_res;
	}

	/**
	 * Sets the popularity res.
	 *
	 * @param popularity_res the new popularity res
	 */
	public void setPopularity_res(String popularity_res) {
		this.popularity_res = popularity_res;
	}

	/**
	 * Gets the popularity.
	 *
	 * @return the popularity
	 */
	public String getPopularity() {
		return popularity;
	}

	/**
	 * Sets the popularity.
	 *
	 * @param popularity the new popularity
	 */
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassPojo [nearby_res = " + nearby_res + ", subzone = "
				+ subzone + ", top_cuisines = " + top_cuisines
				+ ", subzone_id = " + subzone_id + ", nightlife_res = "
				+ nightlife_res + ", nightlife_index = " + nightlife_index
				+ ", city = " + city + ", popularity_res = " + popularity_res
				+ ", popularity = " + popularity + "]";
	}

}
