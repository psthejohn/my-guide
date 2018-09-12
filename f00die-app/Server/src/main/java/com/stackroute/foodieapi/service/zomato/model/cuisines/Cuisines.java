package com.stackroute.foodieapi.service.zomato.model.cuisines;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cuisines
{
	public Cuisines() {
		super();
	}

	@JsonProperty("cuisine")
    private Cuisine cuisine;

    public Cuisine getCuisine ()
    {
        return cuisine;
    }

    public void setCuisine (Cuisine cuisine)
    {
        this.cuisine = cuisine;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cuisine = "+cuisine+"]";
    }
}
