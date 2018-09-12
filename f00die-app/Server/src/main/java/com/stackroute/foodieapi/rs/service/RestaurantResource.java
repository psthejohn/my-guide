/*
 * 
 */
package com.stackroute.foodieapi.rs.service;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.stereotype.Service;

import com.stackroute.foodieapi.service.zomato.model.restaurant.Restaurant;


/**
 * The Interface RestaurantResource.
 */
@CrossOriginResourceSharing(allowAllOrigins=true)
@Path("/restaurant")
@Service
@Api("/restaurant")
public interface RestaurantResource {

	/**
	 * Gets the restaurants by id.
	 *
	 * @param restaurantId the restaurant id
	 * @return the restaurants by id
	 */
	
	@GET
	@Path("/{restaurantId}")
	@Produces(MediaType.APPLICATION_JSON)
	Restaurant getRestaurantsById(@PathParam("restaurantId") String restaurantId);

}
