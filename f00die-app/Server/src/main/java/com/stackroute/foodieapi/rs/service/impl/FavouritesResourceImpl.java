package com.stackroute.foodieapi.rs.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.foodieapi.entity.Favourite;
import com.stackroute.foodieapi.rs.service.FavouritesResource;
import com.stackroute.foodieapi.service.FavouriteService;

@Service
public class FavouritesResourceImpl implements FavouritesResource {
	private static final Logger logger = LoggerFactory
			.getLogger(FavouritesResourceImpl.class);

	
	
	public FavouritesResourceImpl() {
		super();
	}

	@Autowired
	private FavouriteService favouriteService;

	@Override
	public List<Favourite> getAllFavourites() {
		logger.info("getAllFavourites:{}");
		return favouriteService.getAllFavourites();
	}

	@Override
	public Favourite addFavourites(String resId) {
		logger.info("addFavourites --->:{}",resId);
		return favouriteService.addFavourites(resId);
	}

	@Override
	public void deleteFavourites(String resId) {
		 favouriteService.deleteFavourites(resId);
	}

}
