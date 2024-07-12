<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, com.food.model.Cart, com.food.model.CartItem, com.food.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout Page</title>
    <link rel="stylesheet" href="CSS/checkout.css">
</head>
<body>
    <header>
        <nav>
            <a href="index.jsp"><div class="logo animate__animated animate__bounce"><img src="images/logo.png" height="60px" alt="Tap Foods"></div></a>
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
                } else{
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
    <main>
        <h1>Checkout</h1>
        <form class="hero" action="checkout">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
            <label for="paymentMethod">Payment Method:</label>
            <select id="paymentMethod" name="paymentMethod" required>
                <option value="" disabled selected>Select</option>
                <option value="debitCard">Debit Card</option>
                <option value="UPI">PayPal</option>
                <option value="netBanking">Net Banking</option>
                <option value="cashOnDelivery">Cash on Delivery</option>
            </select>
            <button type="submit">Place Order</button>
        </form>
    </main>
    <footer>
        <p>&copy; 2024 Tap Foods. All Rights Reserved.</p>
    </footer>
</body>
</html>
