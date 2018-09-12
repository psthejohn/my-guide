package com.stackroute.foodieapi.rs.service;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.stereotype.Service;

import com.stackroute.foodieapi.service.zomato.model.cities.Cities;
//issue 8, get all cities with city id for a city name
// http://localhost:8080/api/cities?city=Charlotte

@CrossOriginResourceSharing(allowAllOrigins=true)
@Path("/cities")
@Service
@Api("/cities")
public interface CitiesResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	Cities getAllCities(@QueryParam("city") String city);
}
