/*
 * 
 */
package com.stackroute.foodieapi.service.zomato.model.restaurant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The Class Location.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "address", "locality", "city", "city_id", "latitude",
		"longitude", "zipcode", "country_id", "locality_verbose" })
public class Location {
	
	
	
	public Location() {
		super();
	}

	/** The city id. */
	private String city_id;

	/** The locality verbose. */
	private String locality_verbose;

	/** The address. */
	private String address;

	/** The country id. */
	private String country_id;

	/** The zipcode. */
	private String zipcode;

	/** The locality. */
	private String locality;

	/** The longitude. */
	private String longitude;

	/** The latitude. */
	private String latitude;

	/** The city. */
	private String city;

	/**
	 * Gets the city id.
	 *
	 * @return the city id
	 */
	public String getCity_id() {
		return city_id;
	}

	/**
	 * Sets the city id.
	 *
	 * @param city_id the new city id
	 */
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	/**
	 * Gets the locality verbose.
	 *
	 * @return the locality verbose
	 */
	public String getLocality_verbose() {
		return locality_verbose;
	}

	/**
	 * Sets the locality verbose.
	 *
	 * @param locality_verbose the new locality verbose
	 */
	public void setLocality_verbose(String locality_verbose) {
		this.locality_verbose = locality_verbose;
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
	 * Gets the zipcode.
	 *
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * Sets the zipcode.
	 *
	 * @param zipcode the new zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Gets the locality.
	 *
	 * @return the locality
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * Sets the locality.
	 *
	 * @param locality the new locality
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassPojo [city_id = " + city_id + ", locality_verbose = "
				+ locality_verbose + ", address = " + address
				+ ", country_id = " + country_id + ", zipcode = " + zipcode
				+ ", locality = " + locality + ", longitude = " + longitude
				+ ", latitude = " + latitude + ", city = " + city + "]";
	}
}
