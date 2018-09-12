package com.stackroute.foodieapi.rs.service.impl;

import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.foodieapi.entity.ReviewEntity;
import com.stackroute.foodieapi.rs.model.ReviewsModel;
import com.stackroute.foodieapi.rs.service.ReviewsResource;
import com.stackroute.foodieapi.service.ReviewsService;
import com.stackroute.foodieapi.service.ZomatoService;
import com.stackroute.foodieapi.service.zomato.model.reviews.Review;
import com.stackroute.foodieapi.service.zomato.model.reviews.Reviews;
import com.stackroute.foodieapi.service.zomato.model.reviews.UserReviews;

@Api("/reviews")
public class ReviewsResourceImpl implements ReviewsResource {

	public ReviewsResourceImpl() {
		super();
	}

	@Autowired
	private ZomatoService zomatoService;
	
	@Autowired
	private ReviewsService reviewsService;

	@Override
	public List<Review> getReviewsForaResturant(String restaurantId) {
		Reviews reviews = zomatoService.getReviews(restaurantId);
		ReviewsModel reviewsModel = new ReviewsModel();
		UserReviews[] user_reviews = reviews.getUser_reviews();
		reviewsModel.setReviews(new ArrayList<Review>());
		for (int i = 0; i < user_reviews.length; i++) {
			reviewsModel.getReviews().add(user_reviews[i].getReview());
		}
		return reviewsModel.getReviews();
		// return
		// "{\"reviews_count\":58,\"reviews_start\":0,\"reviews_shown\":5,\"user_reviews\":[{\"review\":{\"rating\":4.5,\"review_text\":\"Ihavetosaythatitwasthebestpizzaihaveevereat!Weorder4slicesofpizzaonewithchickenonemargaritaand2withsausageallo...\",\"id\":\"31788799\",\"rating_color\":\"3F7E00\",\"review_time_friendly\":\"3monthsago\",\"rating_text\":\"Lovedit!\",\"timestamp\":1505816133,\"likes\":0,\"user\":{\"name\":\"MehtaabSingh\",\"foodie_level\":\"SuperFoodie\",\"foodie_level_num\":10,\"foodie_color\":\"f58552\",\"profile_url\":\"https://www.zomato.com/users/mehtaab-singh-46244815?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"profile_image\":\"https://b.zmtcdn.com/images/user_avatars/wine_2x.png?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A\",\"profile_deeplink\":\"zomato://u/46244815\"},\"comments_count\":0}},{\"review\":{\"rating\":3.5,\"review_text\":\"Thepizzawasdecent,notthebestI'vehad.Thestaffwasgreat-knowledgeableandwillingtogiverecommendations.Extensivewinelist.Th...\",\"id\":\"30119358\",\"rating_color\":\"9ACD32\",\"review_time_friendly\":\"8monthsago\",\"rating_text\":\"GoodEnough\",\"timestamp\":1492821318,\"likes\":0,\"user\":{\"name\":\"Jess\",\"foodie_level\":\"Foodie\",\"foodie_level_num\":3,\"foodie_color\":\"ffd35d\",\"profile_url\":\"https://www.zomato.com/users/jess-30953380?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"profile_image\":\"https://b.zmtcdn.com/images/user_avatars/mug_2x.png?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A\",\"profile_deeplink\":\"zomato://u/30953380\"},\"comments_count\":0}},{\"review\":{\"rating\":4.5,\"review_text\":\"AsatouristinNewYorkCitywehadtovisittheoldestpizzeriainthecity.Wewaitedonlyabout20minutes.Thepizzawasreallytastya...\",\"id\":\"29457375\",\"rating_color\":\"3F7E00\",\"review_time_friendly\":\"10monthsago\",\"rating_text\":\"Lovedit!\",\"timestamp\":1486794105,\"likes\":1,\"user\":{\"name\":\"RealtyConnectErikLaine\",\"zomato_handle\":\"realtyconnecteriklaine\",\"foodie_level\":\"BigFoodie\",\"foodie_level_num\":6,\"foodie_color\":\"ffae4f\",\"profile_url\":\"https://www.zomato.com/realtyconnecteriklaine?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"profile_image\":\"https://b.zmtcdn.com/data/user_profile_pictures/688/e843ba5449d22a38fb051430ec055688.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A\",\"profile_deeplink\":\"zomato://u/36597012\"},\"comments_count\":0}},{\"review\":{\"rating\":2.5,\"review_text\":\"Oilypepporinipizza.Avoid.Pastaallanormabelowaveragethecheeseislikesourcream.Alsoavoid.Poorpresentation.Goodservice.Prom...\",\"id\":\"29447510\",\"rating_color\":\"FFBA00\",\"review_time_friendly\":\"10monthsago\",\"rating_text\":\"Well...\",\"timestamp\":1486697274,\"likes\":0,\"user\":{\"name\":\"MaherKoussa\",\"foodie_level\":\"Foodie\",\"foodie_level_num\":3,\"foodie_color\":\"ffd35d\",\"profile_url\":\"https://www.zomato.com/users/maher-koussa-33759750?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"profile_image\":\"https://b.zmtcdn.com/data/user_profile_pictures/d93/86f4e293616755734aa14bc4a5938d93.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A\",\"profile_deeplink\":\"zomato://u/33759750\"},\"comments_count\":0}},{\"review\":{\"rating\":3,\"review_text\":\"IdefinitelyenjoygoingbacktoOttoasIamapizzalover.Lotsofchoices,andIthinkwetriedthemall.Someofthepizzasmissthemar...\",\"id\":\"25792145\",\"rating_color\":\"CDD614\",\"review_time_friendly\":\"Dec20,2015\",\"rating_text\":\"Average\",\"timestamp\":1450626201,\"likes\":0,\"user\":{\"name\":\"ARB\",\"zomato_handle\":\"arbny\",\"foodie_level\":\"Connoisseur\",\"foodie_level_num\":13,\"foodie_color\":\"e95151\",\"profile_url\":\"https://www.zomato.com/arbny?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\"profile_image\":\"https://b.zmtcdn.com/data/user_profile_pictures/37d/d960d45ec19b360df02b8117529d437d.jpg?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A\",\"profile_deeplink\":\"zomato://u/21244646\"},\"comments_count\":0}}],\"RespondtoreviewsviaZomatoDashboard\":\"https://www.zomato.com/business/claim?ref=rpg&resid=16774318#claim\"}";
	}

	@Override
	public ReviewEntity postReviewsForaResturant(String myRiew,
			String restaurantId,String rating) {
		ReviewEntity reviewEntity=new ReviewEntity();
		reviewEntity.setId(restaurantId);
		reviewEntity.setReview_text(myRiew);
		reviewEntity.setRating(rating);
		reviewsService.create(reviewEntity);
		return reviewEntity;
	}

	@Override
	public ReviewEntity updateReviewsForaResturant(String myRiew,
			String restaurantId,String rating) {
		ReviewEntity reviewEntity=new ReviewEntity();
		reviewEntity.setId(restaurantId);
		reviewEntity.setReview_text(myRiew);
		reviewEntity.setRating(rating);
		reviewsService.update(reviewEntity);
		return reviewEntity;
	}

	@Override
	public ReviewEntity getMyReviewsForaResturant(String restaurantId) {
		return reviewsService.get(restaurantId);
	}

}
