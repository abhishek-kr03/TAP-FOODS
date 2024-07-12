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

import com.food.DAO.RestaurantDAO;
import com.food.model.Restaurant;

public class RestuarantDAOImpl implements RestaurantDAO{
	
	Scanner scan = new Scanner(System.in);
	String url = "jdbc:mysql://localhost:3306/food_delivery_app";
	String user = "root";
	String pass = "root";
	Connection connection = null;
	String insertQuery = "INSERT INTO `restaurant` (`restaurant_name`,`cousine_type`,`delivery_time`,`address`,`rating`,`is_active`) VALUES (?,?,?,?,?,?)";
	String retreiveQuery = "SELECT * FROM `restaurant` WHERE `restaurant_id` = ?";
	String updateQuery = "UPDATE `restaurant` SET `restaurant_name` = ? , `cousine_type` = ? , `delivery_time` = ? , `address` = ? ,`rating` = ? ,`is_active`= ? WHERE `restaurant_id` = ?";
	String deleteQuery = "DELETE FROM `restaurant` WHERE `restaurant_id` = ?";
	String selectQuery = "Select * FROM `restaurant`";
	PreparedStatement statement = null;
	Statement statement2 = null;
    ResultSet res = null;	
    
    public RestuarantDAOImpl() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url , user , pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		try {
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, restaurant.getRestaurantName());
			statement.setString(2, restaurant.getCusineType());
			statement.setInt(3, restaurant.getDeliveryTime());
			statement.setString(4, restaurant.getAddress());
			statement.setDouble(5, restaurant.getRating());
			statement.setBoolean(6, restaurant.getIsActive());
			System.out.println("row affected: " + statement.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		Restaurant restaurant = null;
		try {
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1,	restaurantId);
			ResultSet res = statement.executeQuery();
			
			if(res.next()) {
				
				restaurant = extractUserFromResultSet(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return restaurant;		
	}
	
	private Restaurant extractUserFromResultSet(ResultSet res) throws SQLException{
		 Restaurant restaurant = new Restaurant();
		 restaurant.setrestaurantId(res.getInt("restaurant_id"));
		 restaurant.setRestaurantName(res.getString("restaurant_name"));
		 restaurant.setCusineType(res.getString("cousine_type"));
		 restaurant.setDeliveryTime(res.getInt("delivery_time"));
		 restaurant.setAddress(res.getString("address"));
		 restaurant.setRating(res.getDouble("rating"));
		 restaurant.setActive(res.getBoolean("is_active"));
		 return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		try {
			statement = connection.prepareStatement(updateQuery);
			statement.setString(1, restaurant.getRestaurantName());
			statement.setString(2, restaurant.getCusineType());
			statement.setInt(3, restaurant.getDeliveryTime());
			statement.setString(4, restaurant.getAddress());
			statement.setDouble(5, restaurant.getRating());
			statement.setBoolean(6, restaurant.getIsActive());
			statement.setInt(7, restaurant.getrestaurantId());

			System.out.println("row affected: " + statement.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int restaurant) {
		try {
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1,restaurant);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> list = new ArrayList<>();
		        try {
		            statement2 = connection.createStatement();
		            res = statement2.executeQuery(selectQuery);
		            while (res.next()) {
		            	Restaurant restaurant = extractUserFromResultSet(res);
                list.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return list;
	}
}
