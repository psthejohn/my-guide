package com.stackroute.foodieapi.service.zomato.model.restaurantscuisines;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "address", "locality", "city", "city_id", "latitude",
		"longitude", "zipcode", "country_id", "locality_verbose" })
public class Location {

	public Location() {
		super();
	}

	@JsonProperty("address")
	private String address;
	@JsonProperty("locality")
	private String locality;
	@JsonProperty("city")
	private String city;
	@JsonProperty("city_id")
	private Integer city_id;
	@JsonProperty("latitude")
	private String latitude;
	@JsonProperty("longitude")
	private String longitude;
	@JsonProperty("zipcode")
	private String zipcode;
	@JsonProperty("country_id")
	private Integer country_id;
	@JsonProperty("locality_verbose")
	private String locality_verbose;

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("locality")
	public String getLocality() {
		return locality;
	}

	@JsonProperty("locality")
	public void setLocality(String locality) {
		this.locality = locality;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("city_id")
	public Integer getCity_id() {
		return city_id;
	}

	@JsonProperty("city_id")
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	@JsonProperty("latitude")
	public String getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longitude")
	public String getLongitude() {
		return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@JsonProperty("zipcode")
	public String getZipcode() {
		return zipcode;
	}

	@JsonProperty("zipcode")
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@JsonProperty("country_id")
	public Integer getCountry_id() {
		return country_id;
	}

	@JsonProperty("country_id")
	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}

	@JsonProperty("locality_verbose")
	public String getLocality_verbose() {
		return locality_verbose;
	}

	@JsonProperty("locality_verbose")
	public void setLocality_verbose(String locality_verbose) {
		this.locality_verbose = locality_verbose;
	}

	

}