package com.stackroute.foodieapi.service.zomato.model.restaurant;


/**
 * The Class NearbyRestaurants.
 */
public class NearbyRestaurants {
	
	public NearbyRestaurants() {
		super();
	}

	/** The restaurant. */
	private Restaurant restaurant;

    /**
     * Gets the restaurant.
     *
     * @return the restaurant
     */
    public Restaurant getRestaurant ()
    {
        return restaurant;
    }

    /**
     * Sets the restaurant.
     *
     * @param restaurant the new restaurant
     */
    public void setRestaurant (Restaurant restaurant)
    {
        this.restaurant = restaurant;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "ClassPojo [restaurant = "+restaurant+"]";
    }
}
