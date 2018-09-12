package com.stackroute.foodieapi.rs.service;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.stereotype.Service;

import com.stackroute.foodieapi.service.zomato.model.cuisines.CuisinesModel;


 
/**
 * The Interface CuisinesResource.
 */
// http://localhost:8080/api/cuisines?cityid=280
@CrossOriginResourceSharing(allowAllOrigins=true)
@Path("/cuisines")
@Service
@Api("/cuisines")
public interface CuisinesResource {

	/**
	 * Gets the all cuisines.
	 *
	 * @param cityid the cityid
	 * @return the all cuisines
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	CuisinesModel getAllCuisines(@QueryParam("cityid") String cityid);
}
