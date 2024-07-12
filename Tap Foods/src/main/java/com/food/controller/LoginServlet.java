package com.food.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.UserDAO;
import com.food.DAOImpl.UserDAOImpl;
import com.food.model.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = new UserDAOImpl();	
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password"); // In a real app, hash and check the password
		
		User loggedInUser = userDao.getUser(email);
		
		if(loggedInUser.getPassword() != null && password.equals(loggedInUser.getPassword())) {
			
			// Create a session and redirect to home page
			HttpSession session = req.getSession();
			session.setAttribute("loggedInUser", loggedInUser);
			resp.sendRedirect("index.jsp");
		}else {
			req.setAttribute("errorMessage", "Invalid username or password");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	
}
