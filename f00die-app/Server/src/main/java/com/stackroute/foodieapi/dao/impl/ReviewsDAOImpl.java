package com.stackroute.foodieapi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.stackroute.foodieapi.dao.ReviewsDAO;
import com.stackroute.foodieapi.entity.ReviewEntity;


/**
 * The Class ReviewsDAOImpl.
 */
@Repository
public class ReviewsDAOImpl implements ReviewsDAO {
	
	public ReviewsDAOImpl() {
		super();
	}


	/** The entity manager. */
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ReviewsDAOImpl.class);

	

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.dao.ReviewsDAO#get(java.lang.String)
	 */
	@Override
	public ReviewEntity get(String reviewId) {
		return entityManager.find(ReviewEntity.class, reviewId);
	}

	

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.dao.ReviewsDAO#create(com.stackroute.foodieapi.entity.ReviewEntity)
	 */
	@Override
	public ReviewEntity create(ReviewEntity reviewEntity) {
		LOGGER.info("create");
		entityManager.merge(reviewEntity);
		return reviewEntity;
	}

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.dao.ReviewsDAO#update(com.stackroute.foodieapi.entity.ReviewEntity)
	 */
	@Override
	public ReviewEntity update(ReviewEntity reviewEntity) {
		entityManager.merge(reviewEntity);
		return reviewEntity;
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
	public EntityManager getEntityManager(EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}
}
