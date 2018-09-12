/*
 * 
 */
package com.stackroute.foodieapi.rs.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.foodieapi.rs.service.RestaurantResource;
import com.stackroute.foodieapi.service.ZomatoService;
import com.stackroute.foodieapi.service.zomato.model.restaurant.Restaurant;


/**
 * The Class RestaurantResourceImpl.
 */
public class RestaurantResourceImpl implements RestaurantResource {


	public RestaurantResourceImpl() {
		super();
	}

	/** The zomato service. */
	// https://developers.zomato.com/api/v2.1/restaurant?res_id=16774318
	@Autowired
	private ZomatoService zomatoService;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(RestaurantResourceImpl.class);

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.rs.service.RestaurantResource#getRestaurantsById(java.lang.String)
	 */
	@Override
	public Restaurant getRestaurantsById(String restaurantId) {
		logger.info("restaurantId:" + restaurantId);
		return zomatoService.getResturantDetails(restaurantId);
		// return
		// "{\"R\":{\"res_id\":16774318},\"apikey\":\"19033159114c0a22991ed9372507ea68\",\"id\":\"16774318\",\"name\":\"OttoEnoteca&Pizzeria\",\"url\":\"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"location\":{\"address\":\"5thAvenue8thStreet,NewYork10003\",\"locality\":\"GreenwichVillage\",\"city\":\"NewYorkCity\",\"city_id\":280,\"latitude\":\"40.7320138889\",\"longitude\":\"-73.9961555556\",\"zipcode\":\"10003\",\"country_id\":216,\"locality_verbose\":\"GreenwichVillage\"},\"switch_to_order_menu\":0,\"cuisines\":\"Pizza,Italian\",\"average_cost_for_two\":60,\"price_range\":4,\"currency\":\"$\",\"offers\":[],\"thumb\":\"https://b.zmtcdn.com/data/res_imagery/16774318_RESTAURANT_fc526e8cfdc1cd8242c50298385d325c.JPG?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A\",\"user_rating\":{\"aggregate_rating\":\"4.3\",\"rating_text\":\"VeryGood\",\"rating_color\":\"5BA829\",\"votes\":\"1071\"},\"photos_url\":\"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop\",\"menu_url\":\"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop\",\"featured_image\":\"https://b.zmtcdn.com/data/res_imagery/16774318_RESTAURANT_fc526e8cfdc1cd8242c50298385d325c.JPG\",\"has_online_delivery\":0,\"is_delivering_now\":0,\"deeplink\":\"zomato://restaurant/16774318\",\"has_table_booking\":0,\"events_url\":\"https://www.zomato.com/new-york-city/otto-enoteca-pizzeria-greenwich-village/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\"}";
	}

}
