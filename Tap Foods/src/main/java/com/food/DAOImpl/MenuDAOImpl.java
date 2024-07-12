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

import com.food.DAO.MenuDAO;
import com.food.model.Menu;

public class MenuDAOImpl implements MenuDAO{

	Scanner scan = new Scanner(System.in);
	String url = "jdbc:mysql://localhost:3306/food_delivery_app";
	String user = "root";
	String pass = "root";
	Connection connection = null;
	String insertQuery = "INSERT INTO `menu` (`item_name`,`description`,`price`,`is_available`) VALUES (?,?,?,?)";
	String retreiveQuery = "SELECT * FROM `menu` WHERE `menu_id` = ?";
	String updateQuery = "UPDATE `menu` SET `item_name` = ? , `description` = ? , `price` = ? , `is_available` = ? WHERE `menu_id` = ?";
	String deleteQuery = "DELETE FROM `menu` WHERE `menu_id` = ?";
	String selectQuery = "Select * FROM `menu`";
	String getRestaurant = "SELECT * FROM `menu` WHERE `restaurant_id` = ?";
	PreparedStatement statement = null;
	Statement statement2 = null;
    ResultSet res = null;
    
    
    public MenuDAOImpl() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url , user , pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    
	@Override
	public void addMenu(Menu menu) {
		try {
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, menu.getItemName());
			statement.setString(2, menu.getDescription());
			statement.setDouble(3, menu.getPrice());
			statement.setBoolean(4, menu.isAvailable());
			System.out.println("row affected: " + statement.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	private Menu extractUserFromResultSet(ResultSet res) throws SQLException{
		 Menu menu = new Menu();
		 menu.setMenuId(res.getInt("menu_id"));
		 menu.setResturantId(res.getInt("restaurant_id"));
		 menu.setItemName(res.getString("item_name"));
		 menu.setDescription(res.getString("description"));
		 menu.setPrice(res.getDouble("price"));
		 menu.setAvailable(res.getBoolean("is_available"));
		 return menu;
	}
	
	
	@Override
	public Menu getMenu(int menuId) {
		Menu menu = null;
		try {
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1,	 menuId);
			ResultSet res = statement.executeQuery();
			
			if(res.next()) {
				
				menu = extractUserFromResultSet(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return menu;
	}
	
	
	

	@Override
	public void updateMenu(Menu menu) {
		try {
			statement = connection.prepareStatement(updateQuery);
			statement.setString(1, menu.getItemName());
			statement.setString(2, menu.getDescription());
			statement.setDouble(3, menu.getPrice());
			statement.setBoolean(4, menu.isAvailable());
			statement.setInt(5, menu.getMenuId());
			System.out.println("row affected: " + statement.executeUpdate());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMenu(int menu) {
		try {
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1,menu);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Menu> getAllMenu(Menu menu) {
 
        List<Menu> list = new ArrayList<>();
        
        try {
            statement2 = connection.createStatement();
            res = statement2.executeQuery(selectQuery);
            while (res.next()) {
            	Menu m = extractUserFromResultSet(res);
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return list;
	}

	
	@Override
	public List<Menu> getMenuByResId(int restaurantId) {

		List<Menu> list = new ArrayList<>();
		
		try {
			statement = connection.prepareStatement(getRestaurant);
			statement.setInt(1,restaurantId);
			res = statement.executeQuery();
			
			while(res.next()) {
				Menu m = extractUserFromResultSet(res);
                list.add(m);
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

