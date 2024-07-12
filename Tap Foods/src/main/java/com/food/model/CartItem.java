package com.food.model;

public class CartItem {

	private int itemId;
	private int resturantId;
	private String name;
	private int quantity;
	private double price;
	
	public CartItem() {
		
	}

	public CartItem(int itemId, int resturantId, String name, int quantity, double price) {
		super();
		this.itemId = itemId;
		this.resturantId = resturantId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
