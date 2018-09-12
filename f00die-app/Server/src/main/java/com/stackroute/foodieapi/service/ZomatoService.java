package com.stackroute.foodieapi.service;

import org.springframework.stereotype.Service;

import com.stackroute.foodieapi.service.zomato.model.cities.Cities;
import com.stackroute.foodieapi.service.zomato.model.cuisines.CuisinesModel;
import com.stackroute.foodieapi.service.zomato.model.restaurant.Restaurant;
import com.stackroute.foodieapi.service.zomato.model.restaurant.Restaurants;
import com.stackroute.foodieapi.service.zomato.model.restaurantscuisines.RestaurantsCuisines;
import com.stackroute.foodieapi.service.zomato.model.reviews.Reviews;


/**
 * The Interface ZomatoService.
 */
@Service
public interface ZomatoService {

	/**
	 * Gets the cities.
	 *
	 * @param city the city
	 * @return the cities
	 */
	Cities getCities(String city);

	/**
	 * Gets the all cuisines.
	 *
	 * @param cityid the cityid
	 * @return the all cuisines
	 */
	CuisinesModel getAllCuisines(String cityid);

	/**
	 * Gets the resturant details.
	 *
	 * @param resID the res ID
	 * @return the resturant details
	 */
	Restaurant getResturantDetails(String resID);

	/**
	 * Gets the reviews.
	 *
	 * @param resID the res ID
	 * @return the reviews
	 */
	Reviews getReviews(String resID);

	/**
	 * Gets the restaurants by geo code.
	 *
	 * @param lat the lat
	 * @param lon the lon
	 * @return the restaurants by geo code
	 */
	Restaurants getRestaurantsByGeoCode(String lat, String lon);

	/**
	 * Gets the restaurants by cuisine.
	 *
	 * @param cityId the city id
	 * @param cuisineId the cuisine id
	 * @return the restaurants by cuisine
	 */
	RestaurantsCuisines getRestaurantsByCuisine(String cityId, String cuisineId);
	
	/**
	 * Gets the restaurants by city cuisine.
	 *
	 * @param city the city
	 * @param cuisine the cuisine
	 * @return the restaurants by city cuisine
	 */
	RestaurantsCuisines getRestaurantsByCityCuisine(String city, String cuisine);

}
