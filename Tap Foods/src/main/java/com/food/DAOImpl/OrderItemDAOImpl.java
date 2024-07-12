package com.food.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.food.DAO.OrderItemDAO;
import com.food.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO{
	
	Scanner scan = new Scanner(System.in);
	String url = "jdbc:mysql://localhost:3306/food_delivery_app";
	String user = "root";
	String pass = "root";
	Connection connection = null;
	String insertQuery = "INSERT INTO `order_item` (`quantity`,`item_total`) VALUES (?,?)";
	String retreiveQuery = "SELECT * FROM `order_item` WHERE `order_item_id` = ?";
	String updateQuery = "UPDATE `order_item` SET `quantity` = ? , `item_total` = ? WHERE `order_item_id` = ?";
	String deleteQuery = "DELETE FROM `order_item` WHERE `order_item_id` = ?";
	String selectQuery = "Select * FROM `order_item`";
	PreparedStatement statement = null;
	Statement statement2 = null;
    ResultSet res = null;

    public OrderItemDAOImpl() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url , user , pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    
	@Override
	public void addOrderItem(OrderItem orderItem) {
		try {
			statement = connection.prepareStatement(insertQuery);
			statement.setInt(1, orderItem.getQuantity());
			statement.setDouble(2, orderItem.getItemTotal());
			System.out.println("row affected: " + statement.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public OrderItem getOrderItem(int orderItemId) {
		OrderItem oItem = null;
		try {
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1,	 orderItemId);
			ResultSet res = statement.executeQuery();
			
			if(res.next()) {
				
				oItem = extractUserFromResultSet(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return oItem;
	}

	private OrderItem extractUserFromResultSet(ResultSet res) throws SQLException{
		OrderItem oItem = new OrderItem();
		oItem.setOrderItemId(res.getInt("order_item_id"));
		oItem.setOrderId(res.getInt("order_id"));
		oItem.setMenuId(res.getInt("menu_id"));
		oItem.setQuantity(res.getInt("quantity"));
		oItem.setItemTotal(res.getDouble("item_total"));
		return oItem;
	}
	
	@Override
	public void updateOrderItem(OrderItem orderItem) {
		try {
			statement = connection.prepareStatement(updateQuery);
			statement.setInt(1, orderItem.getQuantity());
			statement.setDouble(2, orderItem.getItemTotal());
			statement.setInt(3, orderItem.getOrderItemId());
			System.out.println("row affected: " + statement.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		try {
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1,orderItemId);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<OrderItem> getAllOrderItem(OrderItem orderItem) {
		List<OrderItem> list = new ArrayList<>();
	        
        try {
            statement2 = connection.createStatement();
            res = statement2.executeQuery(selectQuery);
            while (res.next()) {
            	OrderItem odi = extractUserFromResultSet(res);
                list.add(odi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return list;	
	}
	
	 // Method to close all database resources
    public void close() {

        try {
            if (connection != null) {
                connection.close(); // Close the connection
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
        try {
            if (statement != null) {
                statement.close(); // Close the statement
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
        try {
            if (statement2 != null) {
                statement2.close(); // Close the prepared statement
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
        try {
            if (res != null) {
                res.close(); // Close the result set
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
    }

}
