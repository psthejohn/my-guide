/*
 * 
 */
package com.stackroute.foodieapi.service.zomato.model.restaurant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The Class Restaurants.
 */
public class Restaurants {

	public Restaurants() {
		super();
	}

	/** The location. */
	@JsonIgnore
    private Location location;

	/** The link. */
	@JsonIgnore
    private String link;  

    /** The restaurant. */
    @JsonProperty("restaurant")
    private Restaurant restaurant;
    
    /** The nearby restaurants. */
    @JsonProperty("nearby_restaurants")
    private NearbyRestaurants[] nearby_restaurants;

    /** The popularity. */
    @JsonIgnore
    private Popularity popularity;

    /**
     * Gets the location.
     *
     * @return the location
     */
    public Location getLocation ()
    {
        return location;
    }

    /**
     * Sets the location.
     *
     * @param location the new location
     */
    public void setLocation (Location location)
    {
        this.location = location;
    }

    /**
     * Gets the link.
     *
     * @return the link
     */
    public String getLink ()
    {
        return link;
    }

    /**
     * Sets the link.
     *
     * @param link the new link
     */
    public void setLink (String link)
    {
        this.link = link;
    }

 

    /**
     * Gets the nearby restaurants.
     *
     * @return the nearby restaurants
     */
    public NearbyRestaurants[] getNearby_restaurants() {
		return nearby_restaurants;
	}

	/**
	 * Sets the nearby restaurants.
	 *
	 * @param nearby_restaurants the new nearby restaurants
	 */
	public void setNearby_restaurants(NearbyRestaurants[] nearby_restaurants) {
		this.nearby_restaurants = nearby_restaurants;
	}

	/**
	 * Gets the popularity.
	 *
	 * @return the popularity
	 */
	public Popularity getPopularity ()
    {
        return popularity;
    }

    /**
     * Sets the popularity.
     *
     * @param popularity the new popularity
     */
    public void setPopularity (Popularity popularity)
    {
        this.popularity = popularity;
    }

    /**
     * Gets the restaurant.
     *
     * @return the restaurant
     */
    public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * Sets the restaurant.
	 *
	 * @param restaurant the new restaurant
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString()
    {
        return "ClassPojo [location = "+location+", link = "+link+", nearby_restaurants = "+nearby_restaurants+", popularity = "+popularity+"]";
    }

}
