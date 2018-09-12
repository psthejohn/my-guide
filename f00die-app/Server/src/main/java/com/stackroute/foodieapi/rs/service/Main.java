package com.stackroute.foodieapi.rs.service;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.stackroute.foodieapi.rs.service.impl.CitiesResourceImpl;
import com.stackroute.foodieapi.rs.service.impl.CuisinesResourceImpl;
import com.stackroute.foodieapi.rs.service.impl.FavouritesResourceImpl;
import com.stackroute.foodieapi.rs.service.impl.RestaurantResourceImpl;
import com.stackroute.foodieapi.rs.service.impl.RestaurantsSearchResourceImpl;
import com.stackroute.foodieapi.rs.service.impl.ReviewsResourceImpl;

@EnableAutoConfiguration
@EntityScan(basePackages = { "com.stackroute.foodieapi.entity" })
@SpringBootApplication
@ComponentScan({ "com.stackroute.foodieapi.rs.service","com.stackroute", "com.stackroute.foodieapi.dao.impl",
		"com.stackroute.foodieapi.service.impl","com.stackroute.foodieapi.dao","com.stackroute.foodieapi.service",
		"com.stackroute.foodieapi.entity" })
public class Main {
	@Autowired
	private Bus bus;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}
	

	@Bean
	public Server rsServer() {
		Swagger2Feature swaggerFeature = new Swagger2Feature();
		swaggerFeature.setTitle("The Foodie-App");
		swaggerFeature.setDescription("Foodie-App Rest API");
		swaggerFeature.setBasePath("/api");
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setBus(bus);
		endpoint.setServiceBeans(Arrays.<Object> asList(cuisinesResource(),
				restaurantResource(), reviewsResource(),
				restaurantsSearchResource(), favouritesResource(),citiesResource()));
		endpoint.setProviders(Arrays.asList(jacksonJsonProvider(),crossOriginResourceSharingFilter(),swaggerFeature));
		//endpoint.setProviders(Arrays.asList(jacksonJsonProvider()));
		endpoint.setFeatures(Arrays.asList(swaggerFeature));
		endpoint.setAddress("/");
		return endpoint.create();
	}

	@Bean
	public CuisinesResource cuisinesResource() {
		return new CuisinesResourceImpl();
	}

	@Bean
	public RestaurantResource restaurantResource() {
		return new RestaurantResourceImpl();
	}

	@Bean
	public ReviewsResource reviewsResource() {
		return new ReviewsResourceImpl();
	}

	@Bean
	public FavouritesResource favouritesResource() {
		return new FavouritesResourceImpl();
	}

	@Bean
	public RestaurantsSearchResource restaurantsSearchResource() {
		return new RestaurantsSearchResourceImpl();
	}

	@Bean
	public JacksonJsonProvider jacksonJsonProvider() {
		return new JacksonJsonProvider();
	}
	
	@Bean
	public CrossOriginResourceSharingFilter crossOriginResourceSharingFilter() {
		return new CrossOriginResourceSharingFilter();
	}
	
	@Bean
	public CitiesResource citiesResource() {
		return new CitiesResourceImpl();
	}
}
