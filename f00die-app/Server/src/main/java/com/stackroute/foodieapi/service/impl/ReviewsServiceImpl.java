package com.stackroute.foodieapi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.foodieapi.dao.FavouritesDAO;
import com.stackroute.foodieapi.dao.ReviewsDAO;
import com.stackroute.foodieapi.entity.ReviewEntity;
import com.stackroute.foodieapi.service.ReviewsService;


/**
 * The Class ReviewsServiceImpl.
 */
@Service
@Transactional
public class ReviewsServiceImpl implements ReviewsService {

	public ReviewsServiceImpl() {
		super();
	}

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ReviewsServiceImpl.class);

	/** The reviews DAO. */
	@Autowired
	private ReviewsDAO reviewsDAO;

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.service.ReviewsService#create(com.stackroute.foodieapi.entity.ReviewEntity)
	 */
	@Override
	public ReviewEntity create(ReviewEntity reviewEntity) {
		// TODO Auto-generated method stub
		return reviewsDAO.create(reviewEntity);
	}

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.service.ReviewsService#update(com.stackroute.foodieapi.entity.ReviewEntity)
	 */
	@Override
	public ReviewEntity update(ReviewEntity reviewEntity) {
		// TODO Auto-generated method stub
		return reviewsDAO.update(reviewEntity);
	}

	/* (non-Javadoc)
	 * @see com.stackroute.foodieapi.service.ReviewsService#get(java.lang.String)
	 */
	@Override
	public ReviewEntity get(String id) {
		// TODO Auto-generated method stub
		return reviewsDAO.get(id);
	}

}
