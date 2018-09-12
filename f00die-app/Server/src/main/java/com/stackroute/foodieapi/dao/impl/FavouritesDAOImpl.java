/*
 * 
 */
package com.stackroute.foodieapi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.stackroute.foodieapi.dao.FavouritesDAO;
import com.stackroute.foodieapi.entity.Favourite;


/**
 * The Class FavouritesDAOImpl.
 */
@Repository
public class FavouritesDAOImpl implements FavouritesDAO {
	
	
	
	
	public FavouritesDAOImpl() {
		super();
	}

	/** The entity manager. */
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FavouritesDAOImpl.class);


	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.dao.FavouritesDAO#delete(java.lang.String)
	 */
	@Override
	public void delete(String resId) {
		Favourite favourite = getFavouritesById(resId);
		LOGGER.info("delete,favourite:{}",favourite);
		if (favourite != null) {
			entityManager.remove(favourite);
		}
	}

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.dao.FavouritesDAO#getFavouriteById(java.lang.String)
	 */
	@Override
	public Favourite getFavouriteById(String resId) {
		return entityManager.find(Favourite.class, resId);
	}

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.dao.FavouritesDAO#getAllFavourites()
	 */
	@Override
	public List<Favourite> getAllFavourites() {
		LOGGER.info("getAllFavourites:{}", entityManager);
		return (List<Favourite>) entityManager.createQuery("FROM Favourite",
				Favourite.class).getResultList();

	}

	/**
	 * Entity manager.
	 *
	 * @param entityManagerFactory the entity manager factory
	 * @return the entity manager
	 */
	@Bean
	@Primary
	@Autowired
	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.dao.FavouritesDAO#create(com.stackroute.foodieapi.entity.Favourite)
	 */
	@Override
	public Favourite create(Favourite favourite) {
		LOGGER.info("create");
		entityManager.persist(favourite);
		return favourite;
	}

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.dao.FavouritesDAO#update(com.stackroute.foodieapi.entity.Favourite)
	 */
	@Override
	public Favourite update(Favourite favourite) {
		entityManager.merge(favourite);
		return favourite;
	}

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.dao.FavouritesDAO#getFavouritesById(java.lang.String)
	 */
	@Override
	public Favourite getFavouritesById(String favId) {
		return entityManager.find(Favourite.class, favId);
	}

}
