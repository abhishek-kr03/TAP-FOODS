package com.food.model;

import java.util.Date;

public class OrderHistory {
	
	private int orderHistoryId;
	private int userId;
	private int orderId;
	private Date orderDate;
	private double totalAmount;
	private String status;
	
	public OrderHistory() {
		
	}

	public OrderHistory(int orderHistoryId, int userId, int orderId, Date orderDate, double totalAmount,
			String status) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.userId = userId;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return orderHistoryId + " " + userId + " " + orderId + " " + orderDate + " " + totalAmount + " " + status;
	}
	
	
	
}