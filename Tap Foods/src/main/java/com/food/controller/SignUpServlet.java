package com.food.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.UserDAO;
import com.food.DAOImpl.UserDAOImpl;
import com.food.model.User;


@WebServlet("/sighup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO userDAOImpl;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userDAOImpl = new UserDAOImpl();
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String confirmPassword = req.getParameter("confirmPassword");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		
		if(password.equals(confirmPassword)) {
			
			int x = userDAOImpl.addUser(new User(username, password, email, address, role));
			
			if(x != 0) {
				resp.sendRedirect("login.jsp");
			}else {
				resp.sendRedirect("signupUnsucessful.jsp");
			}
		}else {
			resp.sendRedirect("passwordError.jsp");
		}
		
	}
}

