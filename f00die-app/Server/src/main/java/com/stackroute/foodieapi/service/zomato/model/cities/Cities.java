package com.stackroute.foodieapi.service.zomato.model.cities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The Class Cities.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cities {

	
	public Cities() {
		super();
	}

	/** The has total. */
	@JsonIgnore
	private String has_total;

	/** The status. */
	@JsonIgnore
	private String status;

	/** The has more. */
	@JsonIgnore
	private String has_more;

	/** The location suggestions. */
	@JsonProperty("location_suggestions")
	private LocationSuggestions[] locationSuggestions;

	/**
	 * Gets the checks for total.
	 *
	 * @return the checks for total
	 */
	public String getHas_total() {
		return has_total;
	}

	/**
	 * Sets the checks for total.
	 *
	 * @param has_total the new checks for total
	 */
	public void setHas_total(String has_total) {
		this.has_total = has_total;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the checks for more.
	 *
	 * @return the checks for more
	 */
	public String getHas_more() {
		return has_more;
	}

	/**
	 * Sets the checks for more.
	 *
	 * @param has_more the new checks for more
	 */
	public void setHas_more(String has_more) {
		this.has_more = has_more;
	}

	/**
	 * Gets the location suggestions.
	 *
	 * @return the location suggestions
	 */
	public LocationSuggestions[] getLocationSuggestions() {
		return locationSuggestions;
	}

	/**
	 * Sets the location suggestions.
	 *
	 * @param locationSuggestions the new location suggestions
	 */
	public void setLocationSuggestions(LocationSuggestions[] locationSuggestions) {
		this.locationSuggestions = locationSuggestions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassPojo [has_total = " + has_total + ", status = " + status
				+ ", has_more = " + has_more + ", location_suggestions = "
				+ locationSuggestions + "]";
	}
}
