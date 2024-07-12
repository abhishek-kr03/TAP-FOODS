package com.food.model;

public class Menu {
	
	private int menuId;
	private int resturantId;
	private String itemName;
	private String description;
	private double price;
	private boolean isAvailable;
	
	public Menu(){
		
	}

	public Menu(int menuId, int resturantId, String itemName, String description, double price, boolean isAvailable) {
		super();
		this.menuId = menuId;
		this.resturantId = resturantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return menuId + " " + resturantId + " " + itemName + " " +description+ " " + price + " " + isAvailable;
	}
	
	
	

}
