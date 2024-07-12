package com.food.DAO;

import java.util.List;
import com.food.model.OrderHistory;


public interface OrderHistoryDAO {

	void addOrderHistry(OrderHistory orderHistory);
	
	OrderHistory getOrderHistry(int orderHistoryId);
	
	void updateOrderHistry(OrderHistory orderHistory);
	
	void deleteOrderHistry(int orderHistoryId);
	
	List<OrderHistory> getAllOrderHistory(OrderHistory orderHistory);
}
