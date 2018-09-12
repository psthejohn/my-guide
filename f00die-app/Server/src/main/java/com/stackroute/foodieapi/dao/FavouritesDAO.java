/*
 * 
 */
package com.stackroute.foodieapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.stackroute.foodieapi.entity.Favourite;


/**
 * The Interface FavouritesDAO.
 */
@Repository
public interface FavouritesDAO {
	
	/**
	 * Creates the.
	 *
	 * @param favourite the favourite
	 * @return the favourite
	 */
	Favourite create(Favourite favourite);

	/**
	 * Update.
	 *
	 * @param favourite the favourite
	 * @return the favourite
	 */
	Favourite update(Favourite favourite);

	/**
	 * Gets the favourites by id.
	 *
	 * @param favId the id
	 * @return the favourites by id
	 */
	Favourite getFavouritesById(String favId);

	/**
	 * Delete.
	 *
	 * @param favId the id
	 */
	void delete(String favId);

	/**
	 * Gets the favourite by id.
	 *
	 * @param favId the id
	 * @return the favourite by id
	 */
	Favourite getFavouriteById(String favId);

	/**
	 * Gets the all favourites.
	 *
	 * @return the all favourites
	 */
	List<Favourite> getAllFavourites();
}
