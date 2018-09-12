package com.stackroute.foodieapi.service.zomato.model.restaurantscuisines;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "res_id" })
public class R {

	public R() {
		super();
	}

	@JsonProperty("res_id")
	private Integer res_id;

	@JsonProperty("res_id")
	public Integer getRes_id() {
		return res_id;
	}

	@JsonProperty("res_id")
	public void setRes_id(Integer res_id) {
		this.res_id = res_id;
	}

	

}
