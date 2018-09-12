/*
 * 
 */
package com.stackroute.foodieapi.rs.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.foodieapi.rs.service.CitiesResource;
import com.stackroute.foodieapi.service.ZomatoService;
import com.stackroute.foodieapi.service.zomato.model.cities.Cities;


/**
 * The Class CitiesResourceImpl.
 */
public class CitiesResourceImpl implements CitiesResource {
	
	
	
	public CitiesResourceImpl() {
		super();
	}

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(CitiesResourceImpl.class);

	/** The zomato service. */
	@Autowired
	private ZomatoService zomatoService;

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.rs.service.CitiesResource#getAllCities(java.lang.String)
	 */
	@Override
	public Cities getAllCities(String city) {
		logger.info("City:{}",city);
		return zomatoService.getCities(city);
	}

}
