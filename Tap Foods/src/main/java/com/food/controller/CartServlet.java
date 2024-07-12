package com.food.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.MenuDAO;
import com.food.DAOImpl.MenuDAOImpl;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Menu;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(CartServlet.class.getName());

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");
        if ("add".equals(action)) {
            addItemToCart(req, cart);
        } else if ("update".equals(action)) {
            updateCartItem(req, cart);
        } else if ("remove".equals(action)) {
            removeItemFromCart(req, cart);
        }

        
        session.setAttribute("cart", cart);
        resp.sendRedirect("cart.jsp");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    private void addItemToCart(HttpServletRequest req, Cart cart) {
        String itemIdStr = req.getParameter("itemId");
        String quantityStr = req.getParameter("quantity");

        if (itemIdStr == null || quantityStr == null) {
            LOGGER.log(Level.SEVERE, "Missing itemId or quantity parameter");
            return; // or handle the error as needed
        }

        try {
            int itemId = Integer.parseInt(itemIdStr);
            int quantity = Integer.parseInt(quantityStr);

            MenuDAO menuDAO = new MenuDAOImpl();
            Menu menuItem = menuDAO.getMenu(itemId);

            HttpSession session = req.getSession();
            session.setAttribute("restaurantId", menuItem.getResturantId());

            if (menuItem != null) {
                CartItem item = new CartItem(menuItem.getMenuId(), menuItem.getResturantId(), menuItem.getItemName(), quantity, menuItem.getPrice());
                cart.addItem(item);
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Error parsing itemId or quantity", e);
        }
        
        
    }

    public void updateCartItem(HttpServletRequest req, Cart cart) {
        String itemIdStr = req.getParameter("itemId");
        String quantityStr = req.getParameter("quantity");

        if (itemIdStr == null || quantityStr == null) {
            LOGGER.log(Level.SEVERE, "Missing itemId or quantity parameter");
            return; // or handle the error as needed
        }

        try {
            int itemId = Integer.parseInt(itemIdStr);
            int quantity = Integer.parseInt(quantityStr);
            cart.updateItem(itemId, quantity);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Error parsing itemId or quantity", e);
        }
    }

    public void removeItemFromCart(HttpServletRequest req, Cart cart) {
        String itemIdStr = req.getParameter("itemId");

        if (itemIdStr == null) {
            LOGGER.log(Level.SEVERE, "Missing itemId parameter");
            return; // or handle the error as needed
        }

        try {
            int itemId = Integer.parseInt(itemIdStr);
            cart.removeItem(itemId);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Error parsing itemId", e);
        }
    }
}
