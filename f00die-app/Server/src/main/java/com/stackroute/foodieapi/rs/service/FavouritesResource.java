package com.stackroute.foodieapi.rs.service;

import io.swagger.annotations.Api;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.stereotype.Service;

import com.stackroute.foodieapi.entity.Favourite;


@CrossOriginResourceSharing(allowAllOrigins = true)
@Service
@Path("/favourites")
@Api("/favourites")
public interface FavouritesResource {

	// http://localhost:8080/api/favourites
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Favourite> getAllFavourites();

	// http://localhost:8080/api/favourites/16774318 :POST
	@POST
	@Path("/{resId}")
	@Produces(MediaType.APPLICATION_JSON)
	Favourite addFavourites(@PathParam("resId") String resId);

	@DELETE
	@Path("/{resId}")
	@Produces(MediaType.APPLICATION_JSON)
	void deleteFavourites(@PathParam("resId") String resId);
}
