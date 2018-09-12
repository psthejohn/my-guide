package com.stackroute.foodieapi.rs.service;

import io.swagger.annotations.Api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.ext.PATCH;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.stereotype.Service;

import com.stackroute.foodieapi.entity.ReviewEntity;
import com.stackroute.foodieapi.service.zomato.model.reviews.Review;



/**
 * The Interface ReviewsResource.
 */
@CrossOriginResourceSharing(allowAllOrigins = true)
@Path("/reviews")
@Service
@Api("/reviews")
public interface ReviewsResource {

	/**
	 * Gets the reviews fora resturant.
	 *
	 * @param restaurantId the restaurant id
	 * @return the reviews fora resturant
	 */
	@GET
	@Path("/{restaurantId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Review> getReviewsForaResturant(
			@PathParam("restaurantId") String restaurantId);

	/**
	 * Post reviews fora resturant.
	 *
	 * @param myRiew the my riew
	 * @param restaurantId the restaurant id
	 * @param rating the rating
	 * @return the review entity
	 */
	@POST
	@Path("/{restaurantId}/myriew")
	@Produces(MediaType.APPLICATION_JSON)
	ReviewEntity postReviewsForaResturant(
			@QueryParam("myRiew") String myRiew,@PathParam("restaurantId") String restaurantId,@QueryParam("rating") String rating);

	/**
	 * Update reviews fora resturant.
	 *
	 * @param myRiew the my riew
	 * @param restaurantId the restaurant id
	 * @param rating the rating
	 * @return the review entity
	 */
	@PATCH
	@Path("/{restaurantId}/myriew")
	@Produces(MediaType.APPLICATION_JSON)
	ReviewEntity updateReviewsForaResturant(
			@QueryParam("myRiew") String myRiew,@PathParam("restaurantId") String restaurantId,@QueryParam("rating") String rating);
	
	/**
	 * Gets the my reviews fora resturant.
	 *
	 * @param restaurantId the restaurant id
	 * @return the my reviews fora resturant
	 */
	@GET
	@Path("/{restaurantId}/myriew")
	@Produces(MediaType.APPLICATION_JSON)
	ReviewEntity getMyReviewsForaResturant(@PathParam("restaurantId") String restaurantId);
}
