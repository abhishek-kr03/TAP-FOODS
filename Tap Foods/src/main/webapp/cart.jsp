<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, com.food.model.Cart, com.food.model.CartItem, com.food.model.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="CSS/cart.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
</head>
<body>
    <header class="animate__animated animate__fadeInDown">
        <nav>
            <a href="index.jsp"><div class="logo animate__animated animate__bounce">
                <img src="images/logo.png" height="60px" alt="Tap Foods">
            </div></a>
            <ul>
                <% 
                User user = (User) session.getAttribute("loggedInUser");
                if(user != null) {
                %>
                <li><a>Welcome, <%=user.getUsername()%>!</a></li>
                <li><a href="restaurant">Restaurants</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="orderHistory">Order History</a></li>
                <li><a href="logout" class="login-btn">Logout</a></li>
                <%
                } else {
                %>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="login.jsp" class="login-btn">Login</a></li>
                <li><a href="signup.jsp" class="signup-btn">SignUp</a></li>  
                <%
                }
                %>
            </ul>
        </nav>
    </header>
    <div class="container animate__animated animate__fadeInUp">
        <h1>Your Shopping Cart</h1>
        <div class="cart-items">
            <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null && !cart.getItems().isEmpty()) {
                for (CartItem item : cart.getItems().values()) {
            %>
            <div class="cart-item animate__animated animate__zoomIn">
                <h3><%= item.getName() %></h3>
                <p>₹<%= item.getPrice() %></p>
                <form action="cart">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <label>Quantity: <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1"></label>
                    <input type="submit" name="action" value="update" class="btn update-btn">
                    <input type="submit" name="action" value="remove" class="btn remove-btn">
                </form>
            </div>
            <%
                }
            } else {
            %>
            <p>Your cart is empty.</p>
            <%
            }
            %>
        </div>
    
        <%-- Add More Items Button --%>
        <%
        Integer restaurantId = (Integer) session.getAttribute("restaurantId");
        if (restaurantId != null) {
        %>
        <a href="menu?restaurantId=<%= restaurantId %>" class="btn add-more-items-btn animate__animated animate__bounceIn">Add More Items</a>
        <%
        } else {
        %>
        <p>Unable to retrieve restaurant menu.</p>
        <%
        }
        %>
    
        <%-- Proceed to Checkout Button --%>
        <%
        if (cart != null && user != null) {
        %>
        <form action="checkout.jsp" method="post">
            <input type="submit" value="Proceed to Checkout" class="btn proceed-to-checkout-btn animate__animated animate__fadeInUp">
        </form>
        <%
        } else if (user == null) {
            response.sendRedirect("login.jsp");
        }
        %>
    </div>
    <script src="JavaScript/cart.js"></script>
</body>
</html>
