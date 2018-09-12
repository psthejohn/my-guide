package com.stackroute.foodieapi.service.zomato.model.cities;

import com.fasterxml.jackson.annotation.JsonTypeName;


/**
 * The Class LocationSuggestions.
 */
@JsonTypeName(value = "location_suggestions")
public class LocationSuggestions {
	
	public LocationSuggestions() {
		super();
	}

	/** The id. */
	private String id;

	/** The state id. */
	private String state_id;

	/** The state code. */
	private String state_code;

	/** The is state. */
	private String is_state;

	/** The country id. */
	private String country_id;

	/** The name. */
	private String name;

	/** The has new ad format. */
	private String has_new_ad_format;

	/** The discovery enabled. */
	private String discovery_enabled;

	/** The should experiment with. */
	private String should_experiment_with;

	/** The state name. */
	private String state_name;

	/** The country name. */
	private String country_name;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the state id.
	 *
	 * @return the state id
	 */
	public String getState_id() {
		return state_id;
	}

	/**
	 * Sets the state id.
	 *
	 * @param state_id the new state id
	 */
	public void setState_id(String state_id) {
		this.state_id = state_id;
	}

	/**
	 * Gets the state code.
	 *
	 * @return the state code
	 */
	public String getState_code() {
		return state_code;
	}

	/**
	 * Sets the state code.
	 *
	 * @param state_code the new state code
	 */
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	/**
	 * Gets the checks if is state.
	 *
	 * @return the checks if is state
	 */
	public String getIs_state() {
		return is_state;
	}

	/**
	 * Sets the checks if is state.
	 *
	 * @param is_state the new checks if is state
	 */
	public void setIs_state(String is_state) {
		this.is_state = is_state;
	}

	/**
	 * Gets the country id.
	 *
	 * @return the country id
	 */
	public String getCountry_id() {
		return country_id;
	}

	/**
	 * Sets the country id.
	 *
	 * @param country_id the new country id
	 */
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
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
	 * Gets the checks for new ad format.
	 *
	 * @return the checks for new ad format
	 */
	public String getHas_new_ad_format() {
		return has_new_ad_format;
	}

	/**
	 * Sets the checks for new ad format.
	 *
	 * @param has_new_ad_format the new checks for new ad format
	 */
	public void setHas_new_ad_format(String has_new_ad_format) {
		this.has_new_ad_format = has_new_ad_format;
	}

	/**
	 * Gets the discovery enabled.
	 *
	 * @return the discovery enabled
	 */
	public String getDiscovery_enabled() {
		return discovery_enabled;
	}

	/**
	 * Sets the discovery enabled.
	 *
	 * @param discovery_enabled the new discovery enabled
	 */
	public void setDiscovery_enabled(String discovery_enabled) {
		this.discovery_enabled = discovery_enabled;
	}

	/**
	 * Gets the should experiment with.
	 *
	 * @return the should experiment with
	 */
	public String getShould_experiment_with() {
		return should_experiment_with;
	}

	/**
	 * Sets the should experiment with.
	 *
	 * @param should_experiment_with the new should experiment with
	 */
	public void setShould_experiment_with(String should_experiment_with) {
		this.should_experiment_with = should_experiment_with;
	}

	/**
	 * Gets the state name.
	 *
	 * @return the state name
	 */
	public String getState_name() {
		return state_name;
	}

	/**
	 * Sets the state name.
	 *
	 * @param state_name the new state name
	 */
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	/**
	 * Gets the country name.
	 *
	 * @return the country name
	 */
	public String getCountry_name() {
		return country_name;
	}

	/**
	 * Sets the country name.
	 *
	 * @param country_name the new country name
	 */
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", state_id = " + state_id
				+ ", state_code = " + state_code + ", is_state = " + is_state
				+ ", country_id = " + country_id + ", name = " + name
				+ ", has_new_ad_format = " + has_new_ad_format
				+ ", discovery_enabled = " + discovery_enabled
				+ ", should_experiment_with = " + should_experiment_with
				+ ", state_name = " + state_name + ", country_name = "
				+ country_name + "]";
	}
}
