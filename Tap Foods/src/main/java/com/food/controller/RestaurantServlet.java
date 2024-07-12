package com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.RestaurantDAO;
import com.food.DAOImpl.RestuarantDAOImpl;
import com.food.model.Restaurant;

@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   private RestaurantDAO restaurantDao;

	   @Override
	    public void init() {
	        restaurantDao = new RestuarantDAOImpl();
	    }

	    @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	
	        List<Restaurant> restaurantList = restaurantDao.getAllRestaurant();
	        System.out.println(restaurantList);
	        
	        HttpSession session = req.getSession();
	        session.setAttribute("restaurantList", restaurantList);
	        System.out.println("working");
	        
	        resp.sendRedirect("restaurant.jsp");
	       
	        
//	        req.setAttribute("restaurantList", restaurantList);
//	        System.out.println("Working");
//	        
//	        RequestDispatcher dispatcher = req.getRequestDispatcher("restaurant.jsp");
//	        dispatcher.include(req, resp);
	    }
	    
	    
	    
//        List<Restaurant> restaurantListSession = (List<Restaurant>) session.getAttribute("restaurantList");
//        System.out.println(restaurantListSession.get(0).getrestaurantId());
//        for (Restaurant restaurant : restaurantListSession) {
//        	System.out.println(restaurant.getrestaurantId());
//		}

	}
