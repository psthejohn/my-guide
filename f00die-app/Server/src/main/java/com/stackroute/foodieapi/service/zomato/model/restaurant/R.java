package com.stackroute.foodieapi.service.zomato.model.restaurant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "res_id" })
public class R {
	
	
	public R() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("res_id")
	private Integer resId;

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	@Override
	public String toString() {
		return "R [resId=" + resId + "]";
	}
	
	
}
