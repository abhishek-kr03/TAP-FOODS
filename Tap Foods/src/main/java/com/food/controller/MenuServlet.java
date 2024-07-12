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

import com.food.DAO.MenuDAO;
import com.food.DAOImpl.MenuDAOImpl;
import com.food.model.Menu;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    MenuDAO menuDAO;
    @Override
    public void init() throws ServletException {
    	menuDAO = new MenuDAOImpl();
    }

    @SuppressWarnings("unused")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	HttpSession session = request.getSession();
    	Integer restaurantId= Integer.parseInt(request.getParameter("restaurantId"));

    	System.out.println("in menu " + restaurantId);
        
        if (restaurantId != null) {
            try {
                int resId = restaurantId;
                List<Menu> menuList = menuDAO.getMenuByResId(resId);
                System.out.println("Retrieved menuList: " + menuList); // Debug statement
                request.setAttribute("menuList", menuList);
            } catch (NumberFormatException e) {
                System.err.println("Invalid restaurantID: " + restaurantId);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error retrieving menu list: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.err.println("restaurantID is null");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
        dispatcher.forward(request, response);
    }

}
