package com.food.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.food.DAOImpl.OrderDAOImpl;
import com.food.DAOImpl.OrderHistoryDAOImpl;
import com.food.DAOImpl.OrderItemDAOImpl;
import com.food.DAOImpl.RestuarantDAOImpl;
import com.food.model.Order;
import com.food.model.OrderHistory;
import com.food.model.OrderItem;
import com.food.model.Restaurant;


@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws ParseException {
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
// USER DESIGN OBJECT Implementation------------------------------------------------------------------------------------------
		
//		UserDAOImp ud = new UserDAOImp();
		
//		User u = new User(2, "raju" , "raju@123","abc@.com","BTM","customer" );
//		ud.addUser(u);
		
//		User user = ud.getUser(1);
//		System.out.println(user);
		
//		User u = new User(1, "raju" , "raju@123","abc@.gmailcom","hsr","customer" );
//		ud.updateUser(u);
		
//		ud.deleteUser(1);
		
//		List<User> li = ud.getAllUser(); // Calling getAllEmployee() method.
//		for (User userDetails : li) {
//			System.out.println(userDetails);
//		}
		
		
// RESTAURANT DESIGN OBJECT Implementation-------------------------------------------------------------------------------------		
		
//		RestuarantDAOImpl rd = new RestuarantDAOImpl();
		
//		Restaurant res = new Restaurant(1, "Ghar ka Khaana", "Veg", 30, "Bihar", 3.2, true);
//		rd.addRestaurant(res);
		
//		Restaurant r = rd.getRestaurant(1);
//		System.out.println(r);
		
		
//		Restaurant restaurant = new Restaurant(1, "Ghar ka Khaana", "Veg", 30, "Patna", 3.2, true);
//		rd.updateRestaurant(restaurant);
		
		
//		rd.deleteRestaurant(2);
		
		
//		List<Restaurant> li = rd.getAllRestaurant(); 
//		for (Restaurant details : li) {
//			System.out.println(details);
//		}
		
		
// MENU DESIGN OBJECT Implementation-------------------------------------------------------------------------------------------	

//		MenuDAOImpl md = new MenuDAOImpl();
		
//		Menu menu = new Menu(2, 2, "paneer", "panner tikka masala",299, true);
//		md.addMenu(menu);
		
//		Menu menu = md.getMenu(1);
//		System.out.println(menu);
		
//		Menu menu = new Menu(3, 0, "Pizza", "Pepparoni", 199, true);
//		md.updateMenu(menu);
		
//		md.deleteMenu(2);

//		Menu r = new Menu();
//		List<Menu> list = md.getAllMenu(r); 
//		for (Menu details : list) {
//			System.out.println(details);
//		}
		
// ORDER DESIGN OBJECT Implementation-------------------------------------------------------------------------------------------
		
//		OrderDAOImpl od = new OrderDAOImpl();
		
//		Order order = new Order(1, 0 , 0,format.parse("2024-06-01"), 189.9, "Delivered","UPI");
//		od.addOrder(order);
	
//		Order order = od.getOrder(1);
//		System.out.println(order);
		
//		Order order = new Order(1, 0 , 0,format.parse("2025-06-01"), 189.9, "Pending","Debit Card");
//		od.updateOrder(order);
		
//		od.deleteOrder(2);
		
//		Order o = new Order();
//		List<Order> list = od.getAllOrder(o); 
//		for (Order details : list) {
//			System.out.println(details);
//		}
		
		
// ORDER ITEM DESIGN OBJECT Implementation-------------------------------------------------------------------------------------

//		OrderItemDAOImpl odi = new OrderItemDAOImpl();
		
//		OrderItem items = new OrderItem(1, 1, 1, 5, 2);
//		odi.addOrderItem(items);
		
//		OrderItem orderItem = odi.getOrderItem(1);
//		System.out.println(orderItem);
		
//		OrderItem items = new OrderItem(1, 1, 1, 3, 2);
//		odi.updateOrderItem(items);
		
//		odi.deleteOrderItem(1);
		
//		OrderItem items = new OrderItem();
//		List<OrderItem> list = odi.getAllOrderItem(items); 
//		for (OrderItem details : list) {
//			System.out.println(details);
//		}
		
// ORDER HISTORY DESIGN OBJECT Implementation-------------------------------------------------------------------------------------

//		OrderHistoryDAOImpl odh = new OrderHistoryDAOImpl();
		
//		OrderHistory orderHistory = new OrderHistory(1, 0 , 0,format.parse("2024-06-01"), 189.9, "Bill Amount");
//		odh.addOrderHistry(orderHistory);
		
//		OrderHistory orderHistry = odh.getOrderHistry(1);
//		System.out.println(orderHistry);
		
//		OrderHistory orderHistory = new OrderHistory(2, 0 , 0,format.parse("2023-06-10"), 600, "Bill Amount");
//		odh.updateOrderHistry(orderHistory);
		
//		odh.deleteOrderHistry(2);
		
//		OrderHistory orderHistory = new OrderHistory();
//		List<OrderHistory> list = odh.getAllOrderHistory(orderHistory);
//		for (OrderHistory oh : list) {
//			System.out.println(oh);
//		}
		
	}

}
