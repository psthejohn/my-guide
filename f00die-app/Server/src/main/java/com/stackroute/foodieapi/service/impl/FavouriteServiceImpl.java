/*
 * 
 */
package com.stackroute.foodieapi.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.foodieapi.dao.FavouritesDAO;
import com.stackroute.foodieapi.entity.Favourite;
import com.stackroute.foodieapi.service.FavouriteService;
import com.stackroute.foodieapi.service.ZomatoService;
import com.stackroute.foodieapi.service.zomato.model.restaurant.Restaurant;


/**
 * The Class FavouriteServiceImpl.
 */
@Service
@Transactional
public class FavouriteServiceImpl implements FavouriteService {

	
	public FavouriteServiceImpl() {
		super();
	}

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FavouriteServiceImpl.class);

	/** The favourites DAO. */
	@Autowired
	private FavouritesDAO favouritesDAO;

	/** The zomato service. */
	@Autowired
	private ZomatoService zomatoService;

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.service.FavouriteService#getAllFavourites()
	 */
	@Override
	public List<Favourite> getAllFavourites() {
		LOGGER.info("getAllFavourites" + favouritesDAO);
		return favouritesDAO.getAllFavourites();
	}

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.service.FavouriteService#addFavourites(java.lang.String)
	 */
	@Override
	public Favourite addFavourites(String resID) {
		Restaurant restaurant = zomatoService.getResturantDetails(resID);
		LOGGER.info("addFavourites restaurant:{}" + restaurant);
		return favouritesDAO.create(createFavourite(restaurant));
	}

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.service.FavouriteService#deleteFavourites(java.lang.String)
	 */
	@Override
	public void deleteFavourites(String resID) {
		favouritesDAO.delete(resID);
	}

	/**
	 * Creates the favourite.
	 *
	 * @param restaurant the restaurant
	 * @return the favourite
	 */
	private Favourite createFavourite(Restaurant restaurant) {
		Favourite favourite = new Favourite();
		favourite.setAddress(restaurant.getLocation().getAddress());
		favourite.setCostOfTwo(restaurant.getAverage_cost_for_two());
		favourite.setDescriptions(restaurant.getCuisines());
		favourite.setId(restaurant.getId());
		favourite.setName(restaurant.getName());
		favourite.setRatings(restaurant.getUser_rating().getAggregate_rating());
		favourite.setVotes(restaurant.getUser_rating().getVotes());
		if (restaurant.getFeatured_image().trim().equals("")) {
			favourite
					.setImageURL("https://b.zmtcdn.com/images/foodshots/cover/pizza3.jpg");
		} else {
			favourite.setImageURL(restaurant.getFeatured_image());
		}
		favourite.setCurrency(restaurant.getCurrency());
		return favourite;
	}
}
