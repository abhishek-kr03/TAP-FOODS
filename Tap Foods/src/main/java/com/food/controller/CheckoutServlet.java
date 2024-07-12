package com.food.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.OrderDAO;
import com.food.DAOImpl.OrderDAOImpl;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.User;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO;

    @Override
    public void init() {
        orderDAO = new OrderDAOImpl();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("loggedInUser");

        if (cart != null && user != null && !cart.getItems().isEmpty()) {
            // Extract checkout form data
            String paymentMethod = request.getParameter("paymentMethod");

            // Create and populate the order object
            Order order = new Order();
            order.setUserId(user.getUserId());

            // Check if restaurantId is set in the session
            Integer restaurantId = (Integer) session.getAttribute("resturantId");
            if (restaurantId == null) {
                // Handle the scenario where restaurantId is not set
                response.sendRedirect("cart.jsp"); // Redirect to cart or show an error message
                return;
            }
            order.setResturantId(restaurantId);
            order.setOrderDate(new Date());
            order.setPaymentMethod(paymentMethod);
            order.setStatus("Pending");

            // Add cart items to the order and calculate the total amount
            double totalAmount = 0;
            for (CartItem item : cart.getItems().values()) {
                // Assuming Order has a method to handle the logic of adding items
                // order.addOrderItem(item);  (this was throwing error)
                totalAmount += item.getPrice() * item.getQuantity();
            }
            order.setTotalAmount(totalAmount);

            // Save the order to the database
            orderDAO.addOrder(order);

            // Clear the cart and redirect to the order confirmation page
            session.removeAttribute("cart");
            session.setAttribute("order", order);
            System.out.println("Checkout");
            response.sendRedirect("order_confirmation.jsp");
        } else {
            response.sendRedirect("cart.jsp"); // Redirect to cart if it's empty or user is not logged in
        }
    }
}
