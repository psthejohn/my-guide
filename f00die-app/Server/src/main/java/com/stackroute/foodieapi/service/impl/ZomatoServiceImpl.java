package com.stackroute.foodieapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;




import com.stackroute.foodieapi.entity.Favourite;
import com.stackroute.foodieapi.service.FavouriteService;
import com.stackroute.foodieapi.service.ZomatoService;
import com.stackroute.foodieapi.service.zomato.model.cities.Cities;
import com.stackroute.foodieapi.service.zomato.model.cities.LocationSuggestions;
import com.stackroute.foodieapi.service.zomato.model.cuisines.Cuisines;
import com.stackroute.foodieapi.service.zomato.model.cuisines.CuisinesModel;
import com.stackroute.foodieapi.service.zomato.model.restaurant.NearbyRestaurants;
import com.stackroute.foodieapi.service.zomato.model.restaurant.Restaurant;
import com.stackroute.foodieapi.service.zomato.model.restaurant.Restaurants;
import com.stackroute.foodieapi.service.zomato.model.restaurantscuisines.RestaurantsCuisines;
import com.stackroute.foodieapi.service.zomato.model.reviews.Reviews;

@Service
public class ZomatoServiceImpl implements ZomatoService {

	public ZomatoServiceImpl() {
		super();
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ZomatoServiceImpl.class);

	@Autowired
	private FavouriteService favouriteService;
	
	@Value("${zomato.dev.api.key}")
	private String zomatoAPIKey;

	@Override
	public Cities getCities(String city) {
		Cities cities = null;
		LOGGER.info("City:{}", city);
		String theUrl = "https://developers.zomato.com/api/v2.1/cities" + "?q="
				+ city;
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpHeaders headers = createHttpHeaders("user-key",
					zomatoAPIKey);
			HttpEntity<String> entity = new HttpEntity<String>("parameters",
					headers);
			ResponseEntity<Cities> response = restTemplate.exchange(theUrl,
					HttpMethod.GET, entity, Cities.class);
			if (response.hasBody()
					&& response.getStatusCode().toString()
							.equalsIgnoreCase("200")) {
				LOGGER.info("Response body:{}", response.getBody()
						.getLocationSuggestions());
				cities = response.getBody();
			}
		} catch (Exception eek) {
			LOGGER.error("Exception:", eek);
		}

		return cities;
	}

	@Override
	public CuisinesModel getAllCuisines(String cityid) {
		// https://developers.zomato.com/api/v2.1/cuisines?city_id=280&sort=rating

		CuisinesModel cuisines = null;
		LOGGER.info("getAllCuisines cityid:{}", cityid);
		String theUrl = "https://developers.zomato.com/api/v2.1/cuisines?city_id="
				+ cityid;
		LOGGER.info("getAllCuisines theUrl:{}", theUrl);
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpHeaders headers = createHttpHeaders("user-key",
					zomatoAPIKey);
			HttpEntity<String> entity = new HttpEntity<String>("parameters",
					headers);
			ResponseEntity<CuisinesModel> response = restTemplate.exchange(
					theUrl, HttpMethod.GET, entity, CuisinesModel.class);
			if (response.hasBody()
					&& response.getStatusCode().toString()
							.equalsIgnoreCase("200")) {
				LOGGER.info("getAllCuisines Response body:{}", response
						.getBody().getCuisines());
				cuisines = response.getBody();
			}
		} catch (Exception eek) {
			LOGGER.error("Exception:", eek);
		}
		return cuisines;

	}

	@Override
	public Restaurant getResturantDetails(String resID) {
		Restaurant restaurant = null;
		String theUrl = "https://developers.zomato.com/api/v2.1/restaurant?res_id="
				+ resID;
		LOGGER.info("getResturantDetails theUrl:{}", theUrl);
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpHeaders headers = createHttpHeaders("user-key",
					zomatoAPIKey);
			HttpEntity<String> entity = new HttpEntity<String>("parameters",
					headers);
			ResponseEntity<Restaurant> response = restTemplate.exchange(theUrl,
					HttpMethod.GET, entity, Restaurant.class);
			if (response.hasBody()
					&& response.getStatusCode().toString()
							.equalsIgnoreCase("200")) {
				LOGGER.info("getAllCuisines Response body:{}", response
						.getBody().getCuisines());
				restaurant = response.getBody();
			}
		} catch (Exception eek) {
			LOGGER.error("Exception:", eek);
		}
		return restaurant;
	}

	@Override
	public Reviews getReviews(String resID) {
		Reviews reviews = null;
		String theUrl = "https://developers.zomato.com/api/v2.1/reviews?res_id="
				+ resID;
		LOGGER.info("getReviews theUrl:{}", theUrl);
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpHeaders headers = createHttpHeaders("user-key",
					zomatoAPIKey);
			HttpEntity<String> entity = new HttpEntity<String>("parameters",
					headers);
			ResponseEntity<Reviews> response = restTemplate.exchange(theUrl,
					HttpMethod.GET, entity, Reviews.class);
			if (response.hasBody()
					&& response.getStatusCode().toString()
							.equalsIgnoreCase("200")) {

				reviews = response.getBody();
			}
		} catch (Exception eek) {
			LOGGER.error("Exception:", eek);
		}
		return reviews;
	}

	@Override
	public Restaurants getRestaurantsByGeoCode(String lat, String lon) {
		Restaurants restaurants = null;
		String theUrl = "https://developers.zomato.com/api/v2.1/geocode?sort=rating&lat="
				+ lat + "&lon=" + lon;
		LOGGER.info("getReviews theUrl:{}", theUrl);
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpHeaders headers = createHttpHeaders("user-key",
					zomatoAPIKey);
			HttpEntity<String> entity = new HttpEntity<String>("parameters",
					headers);
			ResponseEntity<Restaurants> response = restTemplate.exchange(
					theUrl, HttpMethod.GET, entity, Restaurants.class);
			LOGGER.info("response:{}", response);
			LOGGER.info("response.getStatusCode().toString():{}", response
					.getStatusCode().toString());
			if (response.hasBody()
					&& response.getStatusCode().toString()
							.equalsIgnoreCase("200")) {

				restaurants = response.getBody();
			}
		} catch (Exception eek) {
			LOGGER.error("Exception:", eek);
		}
		checkForFavouritesAndImage(restaurants);
		return restaurants;
	}

	

	@Override
	public RestaurantsCuisines getRestaurantsByCuisine(String cityId,
			String cuisineId) {
		RestaurantsCuisines restaurantsCuisines = null;
		String theUrl = "https://developers.zomato.com/api/v2.1/search?sort=rating&entity_id="
				+ cityId + "&entity_type=city&cuisines=" + cuisineId;
		LOGGER.info("getRestaurantsByCuisine theUrl:{}", theUrl);
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpHeaders headers = createHttpHeaders("user-key",
					zomatoAPIKey);
			HttpEntity<String> entity = new HttpEntity<String>("parameters",
					headers);
			ResponseEntity<RestaurantsCuisines> response = restTemplate
					.exchange(theUrl, HttpMethod.GET, entity,
							RestaurantsCuisines.class);
			LOGGER.info("getRestaurantsByCuisine response:{}", response);
			LOGGER.info(
					"getRestaurantsByCuisine response.getStatusCode().toString():{}",
					response.getStatusCode().toString());

			LOGGER.info(
					"getRestaurantsByCuisine response.getStatusCode().toString():{}",
					response.getBody());
			if (response.hasBody()
					&& response.getStatusCode().toString()
							.equalsIgnoreCase("200")) {

				restaurantsCuisines = response.getBody();
			}
		} catch (Exception eek) {
			LOGGER.error("Exception:", eek);
		}
		return restaurantsCuisines;
	}

	@Override
	public RestaurantsCuisines getRestaurantsByCityCuisine(String city,
			String cuisine) {
		String cityId = "";
		String cuisineId = "";
		Cities cities = this.getCities(city);
		LocationSuggestions[] locationSuggestions = cities
				.getLocationSuggestions();
		for (int i = 0; i < locationSuggestions.length; i++) {
			LOGGER.info(
					"getRestaurantsByCityCuisine:locationSuggestions[i].getName():{}",
					locationSuggestions[i].getName());
			if (locationSuggestions[i].getName().toUpperCase()
					.contains(city.toUpperCase())) {
				cityId = locationSuggestions[i].getId();
				break;
			}
		}
		LOGGER.info("getRestaurantsByCityCuisine:{}", cityId);
		CuisinesModel cuisinesModel = this.getAllCuisines(cityId);
		Cuisines[] cuisines = cuisinesModel.getCuisines();
		for (int i = 0; i < cuisines.length; i++) {
			LOGGER.info(
					"getRestaurantsByCityCuisine:cuisines[i].getCuisine().getCuisine_name():{}",
					cuisines[i].getCuisine().getCuisine_name());
			if (cuisines[i].getCuisine().getCuisine_name().toUpperCase()
					.contains(cuisine.toUpperCase())) {
				cuisineId = cuisines[i].getCuisine().getCuisine_id();
				break;
			}
		}
		LOGGER.info("getRestaurantsByCityCuisine:{}", cuisineId);
		RestaurantsCuisines restaurantsCuisines = getRestaurantsByCuisine(
				cityId, cuisineId);
		checkForFavouritesAndImage(restaurantsCuisines);
		return restaurantsCuisines;
	}

	private HttpHeaders createHttpHeaders(String headerName, String headerValue) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add(headerName, headerValue);
		return headers;
	}
	
	private void checkForFavouritesAndImage(RestaurantsCuisines restaurantsCuisines) {
		List<Favourite> favourites = favouriteService.getAllFavourites();
		List favIds = new ArrayList();
		for (int i = 0; i < favourites.size(); i++) {
			favIds.add(favourites.get(i).getId());
		}
		for (int i = 0; i < restaurantsCuisines.getRestaurants().size(); i++) {
			LOGGER.info("checkForFavourites[i].getRestaurant().getId():{}",
					restaurantsCuisines.getRestaurants().get(i).getRestaurant().getId());
			if (favIds.contains(restaurantsCuisines.getRestaurants().get(i).getRestaurant().getId())) {
				restaurantsCuisines.getRestaurants().get(i).getRestaurant().setFav(true);
			}
			if (restaurantsCuisines.getRestaurants().get(i).getRestaurant().getFeatured_image().trim().equalsIgnoreCase("")) {
				restaurantsCuisines.getRestaurants().get(i).getRestaurant().setFeatured_image("https://b.zmtcdn.com/images/foodshots/cover/pizza3.jpg");
			}
		}
	}

	private void checkForFavouritesAndImage(Restaurants restaurants) {
		List<Favourite> favourites = favouriteService.getAllFavourites();
		List favIds = new ArrayList();
		for (int i = 0; i < favourites.size(); i++) {
			favIds.add(favourites.get(i).getId());
		}
		NearbyRestaurants[] nearbyRestaurants = restaurants
				.getNearby_restaurants();
		for (int i = 0; i < nearbyRestaurants.length; i++) {
			LOGGER.info("nearbyRestaurants[i].getRestaurant().getId():{}",
					nearbyRestaurants[i].getRestaurant().getId());
			if (favIds.contains(nearbyRestaurants[i].getRestaurant().getId())) {
				
				nearbyRestaurants[i].getRestaurant().setFav(true);
			}
			if(nearbyRestaurants[i].getRestaurant().getFeatured_image().trim().equalsIgnoreCase("")){
				nearbyRestaurants[i].getRestaurant().setFeatured_image("https://b.zmtcdn.com/images/foodshots/cover/pizza3.jpg");
			}
		}
	}

}
