/*
 * 
 */
package com.stackroute.foodieapi.service.zomato.model.restaurantscuisines;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The Class Restaurant_.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "R", "apikey", "id", "name", "url", "location",
		"switch_to_order_menu", "cuisines", "average_cost_for_two",
		"price_range", "currency", "offers", "thumb", "user_rating",
		"photos_url", "menu_url", "featured_image", "has_online_delivery",
		"is_delivering_now", "deeplink", "has_table_booking", "events_url",
		"establishment_types" })
public class Restaurant_ {

	public Restaurant_() {
		super();
	}

	/** The fav. */
	private boolean fav;
	
	/** The r. */
	@JsonProperty("R")
	private R r;
	
	/** The apikey. */
	@JsonProperty("apikey")
	private String apikey;
	
	/** The id. */
	@JsonProperty("id")
	private String id;
	
	/** The name. */
	@JsonProperty("name")
	private String name;
	
	/** The url. */
	@JsonProperty("url")
	private String url;
	
	/** The location. */
	@JsonProperty("location")
	private Location location;
	
	/** The switch to order menu. */
	@JsonProperty("switch_to_order_menu")
	private Integer switch_to_order_menu;
	
	/** The cuisines. */
	@JsonProperty("cuisines")
	private String cuisines;
	
	/** The average cost for two. */
	@JsonProperty("average_cost_for_two")
	private Integer average_cost_for_two;
	
	/** The price range. */
	@JsonProperty("price_range")
	private Integer price_range;
	
	/** The currency. */
	@JsonProperty("currency")
	private String currency;
	
	/** The offers. */
	@JsonProperty("offers")
	private List<Object> offers = null;
	
	/** The thumb. */
	@JsonProperty("thumb")
	private String thumb;
	
	/** The user rating. */
	@JsonProperty("user_rating")
	private User_rating user_rating;
	
	/** The photos url. */
	@JsonProperty("photos_url")
	private String photos_url;
	
	/** The menu url. */
	@JsonProperty("menu_url")
	private String menu_url;
	
	/** The featured image. */
	@JsonProperty("featured_image")
	private String featured_image;
	
	/** The has online delivery. */
	@JsonProperty("has_online_delivery")
	private Integer has_online_delivery;
	
	/** The is delivering now. */
	@JsonProperty("is_delivering_now")
	private Integer is_delivering_now;
	
	/** The deeplink. */
	@JsonProperty("deeplink")
	private String deeplink;
	
	/** The has table booking. */
	@JsonProperty("has_table_booking")
	private Integer has_table_booking;
	
	/** The events url. */
	@JsonProperty("events_url")
	private String events_url;
	
	/** The establishment types. */
	@JsonProperty("establishment_types")
	private List<Object> establishment_types = null;

	/**
	 * Gets the r.
	 *
	 * @return the r
	 */
	@JsonProperty("R")
	public R getR() {
		return r;
	}

	/**
	 * Sets the r.
	 *
	 * @param r the new r
	 */
	@JsonProperty("R")
	public void setR(R r) {
		this.r = r;
	}

	/**
	 * Gets the apikey.
	 *
	 * @return the apikey
	 */
	@JsonProperty("apikey")
	public String getApikey() {
		return apikey;
	}

	/**
	 * Sets the apikey.
	 *
	 * @param apikey the new apikey
	 */
	@JsonProperty("apikey")
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	@JsonProperty("location")
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Gets the switch to order menu.
	 *
	 * @return the switch to order menu
	 */
	@JsonProperty("switch_to_order_menu")
	public Integer getSwitch_to_order_menu() {
		return switch_to_order_menu;
	}

	/**
	 * Sets the switch to order menu.
	 *
	 * @param switch_to_order_menu the new switch to order menu
	 */
	@JsonProperty("switch_to_order_menu")
	public void setSwitch_to_order_menu(Integer switch_to_order_menu) {
		this.switch_to_order_menu = switch_to_order_menu;
	}

	/**
	 * Gets the cuisines.
	 *
	 * @return the cuisines
	 */
	@JsonProperty("cuisines")
	public String getCuisines() {
		return cuisines;
	}

	/**
	 * Sets the cuisines.
	 *
	 * @param cuisines the new cuisines
	 */
	@JsonProperty("cuisines")
	public void setCuisines(String cuisines) {
		this.cuisines = cuisines;
	}

	/**
	 * Gets the average cost for two.
	 *
	 * @return the average cost for two
	 */
	@JsonProperty("average_cost_for_two")
	public Integer getAverage_cost_for_two() {
		return average_cost_for_two;
	}

	/**
	 * Sets the average cost for two.
	 *
	 * @param average_cost_for_two the new average cost for two
	 */
	@JsonProperty("average_cost_for_two")
	public void setAverage_cost_for_two(Integer average_cost_for_two) {
		this.average_cost_for_two = average_cost_for_two;
	}

	/**
	 * Gets the price range.
	 *
	 * @return the price range
	 */
	@JsonProperty("price_range")
	public Integer getPrice_range() {
		return price_range;
	}

	/**
	 * Sets the price range.
	 *
	 * @param price_range the new price range
	 */
	@JsonProperty("price_range")
	public void setPrice_range(Integer price_range) {
		this.price_range = price_range;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the offers.
	 *
	 * @return the offers
	 */
	@JsonProperty("offers")
	public List<Object> getOffers() {
		return offers;
	}

	/**
	 * Sets the offers.
	 *
	 * @param offers the new offers
	 */
	@JsonProperty("offers")
	public void setOffers(List<Object> offers) {
		this.offers = offers;
	}

	/**
	 * Gets the thumb.
	 *
	 * @return the thumb
	 */
	@JsonProperty("thumb")
	public String getThumb() {
		return thumb;
	}

	/**
	 * Sets the thumb.
	 *
	 * @param thumb the new thumb
	 */
	@JsonProperty("thumb")
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	/**
	 * Gets the user rating.
	 *
	 * @return the user rating
	 */
	@JsonProperty("user_rating")
	public User_rating getUser_rating() {
		return user_rating;
	}

	/**
	 * Sets the user rating.
	 *
	 * @param user_rating the new user rating
	 */
	@JsonProperty("user_rating")
	public void setUser_rating(User_rating user_rating) {
		this.user_rating = user_rating;
	}

	/**
	 * Gets the photos url.
	 *
	 * @return the photos url
	 */
	@JsonProperty("photos_url")
	public String getPhotos_url() {
		return photos_url;
	}

	/**
	 * Sets the photos url.
	 *
	 * @param photos_url the new photos url
	 */
	@JsonProperty("photos_url")
	public void setPhotos_url(String photos_url) {
		this.photos_url = photos_url;
	}

	/**
	 * Gets the menu url.
	 *
	 * @return the menu url
	 */
	@JsonProperty("menu_url")
	public String getMenu_url() {
		return menu_url;
	}

	/**
	 * Sets the menu url.
	 *
	 * @param menu_url the new menu url
	 */
	@JsonProperty("menu_url")
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}

	/**
	 * Gets the featured image.
	 *
	 * @return the featured image
	 */
	@JsonProperty("featured_image")
	public String getFeatured_image() {
		return featured_image;
	}

	/**
	 * Sets the featured image.
	 *
	 * @param featured_image the new featured image
	 */
	@JsonProperty("featured_image")
	public void setFeatured_image(String featured_image) {
		this.featured_image = featured_image;
	}

	/**
	 * Gets the checks for online delivery.
	 *
	 * @return the checks for online delivery
	 */
	@JsonProperty("has_online_delivery")
	public Integer getHas_online_delivery() {
		return has_online_delivery;
	}

	/**
	 * Sets the checks for online delivery.
	 *
	 * @param has_online_delivery the new checks for online delivery
	 */
	@JsonProperty("has_online_delivery")
	public void setHas_online_delivery(Integer has_online_delivery) {
		this.has_online_delivery = has_online_delivery;
	}

	/**
	 * Gets the checks if is delivering now.
	 *
	 * @return the checks if is delivering now
	 */
	@JsonProperty("is_delivering_now")
	public Integer getIs_delivering_now() {
		return is_delivering_now;
	}

	/**
	 * Sets the checks if is delivering now.
	 *
	 * @param is_delivering_now the new checks if is delivering now
	 */
	@JsonProperty("is_delivering_now")
	public void setIs_delivering_now(Integer is_delivering_now) {
		this.is_delivering_now = is_delivering_now;
	}

	/**
	 * Gets the deeplink.
	 *
	 * @return the deeplink
	 */
	@JsonProperty("deeplink")
	public String getDeeplink() {
		return deeplink;
	}

	/**
	 * Sets the deeplink.
	 *
	 * @param deeplink the new deeplink
	 */
	@JsonProperty("deeplink")
	public void setDeeplink(String deeplink) {
		this.deeplink = deeplink;
	}

	/**
	 * Gets the checks for table booking.
	 *
	 * @return the checks for table booking
	 */
	@JsonProperty("has_table_booking")
	public Integer getHas_table_booking() {
		return has_table_booking;
	}

	/**
	 * Sets the checks for table booking.
	 *
	 * @param has_table_booking the new checks for table booking
	 */
	@JsonProperty("has_table_booking")
	public void setHas_table_booking(Integer has_table_booking) {
		this.has_table_booking = has_table_booking;
	}

	/**
	 * Gets the events url.
	 *
	 * @return the events url
	 */
	@JsonProperty("events_url")
	public String getEvents_url() {
		return events_url;
	}

	/**
	 * Sets the events url.
	 *
	 * @param events_url the new events url
	 */
	@JsonProperty("events_url")
	public void setEvents_url(String events_url) {
		this.events_url = events_url;
	}

	/**
	 * Gets the establishment types.
	 *
	 * @return the establishment types
	 */
	@JsonProperty("establishment_types")
	public List<Object> getEstablishment_types() {
		return establishment_types;
	}

	/**
	 * Sets the establishment types.
	 *
	 * @param establishment_types the new establishment types
	 */
	@JsonProperty("establishment_types")
	public void setEstablishment_types(List<Object> establishment_types) {
		this.establishment_types = establishment_types;
	}

	/**
	 * Checks if is fav.
	 *
	 * @return true, if is fav
	 */
	public boolean isFav() {
		return fav;
	}

	/**
	 * Sets the fav.
	 *
	 * @param fav the new fav
	 */
	public void setFav(boolean fav) {
		this.fav = fav;
	}


}