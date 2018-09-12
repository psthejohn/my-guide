package com.stackroute.foodieapi.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.foodieapi.entity.Favourite;

@Service
public interface FavouriteService {

	List<Favourite> getAllFavourites();
	
	Favourite addFavourites(String resID);
	
	void deleteFavourites(String resID);
}
