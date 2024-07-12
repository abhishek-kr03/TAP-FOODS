package com.food.model;

public class Restaurant {

	private int restaurantId;
	private String restaurantName;
	private String cusineType;
	private int deliveryTime;
	private String address;
	private double rating;
	private boolean isActive;
	private String imgPath;
	
	public Restaurant() {
		
	}

	public Restaurant(int restaurantId, String restaurantName, String cusineType, int deliveryTime, String address, double rating, boolean isActive) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.cusineType = cusineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
	}
	
	
	public int getrestaurantId() {
		return restaurantId;
	}

	public void setrestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getCusineType() {
		return cusineType;
	}

	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return restaurantId + " " + restaurantName + " " + deliveryTime + " " + address + " " + rating + " " + isActive;
	}
	
	
}
