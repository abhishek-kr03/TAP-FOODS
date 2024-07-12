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

import com.food.DAO.UserDAO;
import com.food.model.User;

public class UserDAOImpl implements UserDAO {
	
	Scanner scan = new Scanner(System.in);
	String url = "jdbc:mysql://localhost:3306/food_delivery_app";
	String user = "root";
	String pass = "root";
	Connection connection = null;
	String insertQuery = "INSERT INTO `user` (`user_name`,`password`,`email`,`address`,`role`) VALUES (?,?,?,?,?)";
	String retreiveQuery = "SELECT * FROM `user` WHERE `email` = ?";
	String updateQuery = "UPDATE `user` SET `user_name` = ? , `password` = ? , `email` = ? , `address` = ? , `role` = ? WHERE `user_id` = ?";
	String deleteQuery = "DELETE FROM `user` WHERE `user_id` = ?";
	String selectQuery = "Select * FROM `user`";
	PreparedStatement statement = null;
	Statement statement2 = null;
    ResultSet res = null;

	public UserDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url , user , pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addUser(User user) {
		try {
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getRole());
			
			return statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public User getUser(String email) {
		
		User user = null;
		
		
		try {
			statement = connection.prepareStatement(retreiveQuery);
			statement.setString(1, email);
			ResultSet res = statement.executeQuery();
			
			if(res.next()) {
				
				user = extractUserFromResultSet(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
		
	}
	private User extractUserFromResultSet(ResultSet res) throws SQLException{
		 User user = new User();
		 user.setUserId(res.getInt("user_id"));
		 user.setUsername(res.getString("user_name"));
		 user.setPassword(res.getString("password"));
		 user.setEmail(res.getString("email"));
		 user.setAddress(res.getString("address"));
		 user.setRole(res.getString("role"));
		 return user;
	}

	@Override
	public void updateUser(User user) {
				
		try {
			statement = connection.prepareStatement(updateQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getRole());
			statement.setInt(6, user.getUserId());
			System.out.println("row affected: " + statement.executeUpdate());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int user) {
		try {
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1,user);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        
        try {
            statement2 = connection.createStatement();
            res = statement2.executeQuery(selectQuery);
            while (res.next()) {
                User u = extractUserFromResultSet(res);
                list.add(u);
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
