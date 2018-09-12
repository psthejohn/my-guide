package com.stackroute.foodieapi.rs.service;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.stereotype.Service;

import com.stackroute.foodieapi.service.zomato.model.restaurant.Restaurants;
import com.stackroute.foodieapi.service.zomato.model.restaurantscuisines.RestaurantsCuisines;

@CrossOriginResourceSharing(allowAllOrigins=true)
@Path("/restaurants")
@Service
@Api("/restaurants")
public interface RestaurantsSearchResource {

	
	// localhost:8080/api/restaurants/geocode?lat=40.742051&lon=-74.004821&sort=rating:GET
	@GET
	@Path("/geocode")
	@Produces(MediaType.APPLICATION_JSON)
	Restaurants getRestaurantsByGeoCode(@QueryParam("lat") String lat,
			@QueryParam("lon") String lon);

	
	// http://localhost:8080/api/restaurants/cuisine?cityId=3&cuisineId=55:GET
	@GET
	@Path("/cuisine")
	@Produces(MediaType.APPLICATION_JSON)
	RestaurantsCuisines getRestaurantsByCuisine(
			@QueryParam("cityId") String cityId,
			@QueryParam("cuisineId") String cuisineId);
	
	
	// http://localhost:8080/api/restaurants/cuisine?cityId=3&cuisineId=55:GET
	@GET
	@Path("/city/cuisine")
	@Produces(MediaType.APPLICATION_JSON)
	RestaurantsCuisines getRestaurantsByCityCuisine(
			@QueryParam("city") String cityId,
			@QueryParam("cuisine") String cuisineId);
}
