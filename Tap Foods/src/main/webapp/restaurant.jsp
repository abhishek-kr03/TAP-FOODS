<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List, com.food.model.User, com.food.model.Restaurant, com.food.DAOImpl.RestuarantDAOImpl" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Page</title>
    <link rel="stylesheet" href="CSS/restaurant.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
</head>
<body>
    <header class="header">
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
                <li><a href="cart" id="cart-button" class="cart">
                    <i class="fas fa-shopping-cart"></i> Cart <span id="cart-count">0</span>
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
    <div class="sticky-bar">
        <label for="sort">Sort by:</label>
        <select id="sort"  class="form-control d-inline w-auto">
            <option value="relevance">Relevance</option>
            <option value="rating">Rating</option>
            <option value="delivery-time">Delivery Time</option>
            <option value="price">Price</option>
        </select>
        <label for="filter">Filter by:</label>
        <input type="checkbox" id="vegetarian" name="vegetarian" value="vegetarian"> Vegetarian
        <input type="checkbox" id="vegan" name="vegan" value="vegan"> Vegan
        <input type="checkbox" id="gluten-free" name="gluten-free" value="gluten-free"> Gluten Free
    </div>
    <section class="restaurants" style="background-color: rgb(255, 253, 253)">
        <h2>Restaurants Near You</h2>
        
        <div class="restaurant-container">
        	<div class="restaurant-item">
                <img src="images/Foods Images/subway.avif" alt="Restaurant 1">
                <h3>Subway</h3>
                <p>Salads,Snacks,Deserts</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/Foods Images/corner house.avif" alt="Restaurant 1">
                <h3>Corner House Ice Cream</h3>
                <p>Ice Cream, Desearts</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/Foods Images/mojo pizza.avif" alt="Restaurant 1">
                <h3>MOJO PIZZA - 2X Toppings</h3>
                <p>Pizzas, Italian, Fast Food,Deserts</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/Foods Images/mcDonalds.avif" alt="Restaurant 1">
                <h3>McDonald's</h3>
                <p>Burger, Beaverages</p>
                <span>40-45 mins</span>
            </div>
            <a href="menu.jsp">
            <div class="restaurant-item">
                <img src="images/Foods Images/UBQ.avif" alt="Restaurant 1">
                <h3>UBQ by Barbeque Nation</h3>
                <p>North Indian, Barbecue, Biryani</p>
                <span>40-45 mins</span>
            </div>
            </a>
            <a href="menu.html">
            <div class="restaurant-item">
                <img src="images/Foods Images/Pizza Hut.avif" alt="Restaurant 1">
                <h3>Pizza Hut</h3>
                <p>Pizzas</p>
                <span>40-45 mins</span>
            </div>
            </a>
            <a href="menu.html">
            <div class="restaurant-item">
                <img src="images/Foods Images/wow momo.avif" alt="Restaurant 1">
                <h3>Wow! Momo</h3>
                <p>Tibetan, Healthy Food</p>
                <span>40-45 mins</span>
            </div>
            </a>
            <div class="restaurant-item">
                <img src="images/Foods Images/Barbeque nation.avif" alt="Restaurant 1">
                <h3>Barbeque Nation</h3>
                <p>North Indian, Barbecue, Biryani</p>
                <span>40-45 mins</span>
            </div>
            
            <div class="restaurant-item">
                <img src="images/Foods Images/kfc.avif" alt="Restaurant 1">
                <h3>KFC</h3>
                <p>Burgers, Fast Foods</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/Foods Images/burgerking.avif" alt="Restaurant 1">
                <h3>Burger King</h3>
                <p>Burgers, Americans</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/Foods Images/wendy's.avif" alt="Restaurant 1">
                <h3>Wendy's Burger</h3>
                <p>Burgers, American Fast Foods</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/Foods Images/dominos.avif" alt="Restaurant 1">
                <h3>Domino's Pizza</h3>
                <p>Pizzas, Italian, Pastas</p>
                <span>40-45 mins</span>
            </div>
            
   	 
   	 
   	 <div class="restaurant-container">
        <% 
        @SuppressWarnings("unchecked")
        List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");
        System.out.println(restaurantList);
        
        if (restaurantList != null) {
            for (Restaurant restaurant : restaurantList) {
        %>
        <a href="menu?restaurantId=<%=restaurant.getrestaurantId()%>">
        <div class="restaurant-item">
            <img src="images/<%= restaurant.getImgPath() %>" alt="<%= restaurant.getRestaurantName() %>">
            <h3><%= restaurant.getRestaurantName() %></h3>
            <p><%= restaurant.getCusineType() %></p>
            <span><%= restaurant.getDeliveryTime() %> mins</span>
        </div>
        </a>
        <% 
            }
        } else {
        %>
        <p>No restaurants available at the moment.</p>
        <% 
        } 
        %>
    </div>
   	 
   	 
   	 
   	 
            <!-- Repeat for other restaurants -->
        </div>
    </section>
    <!-- Footer -->
    <footer>
        <div class="footer-content">
            <p>&copy; 2024 Tap Foods. All Rights Reserved.</p>
            <ul>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Terms of Service</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>
    </footer>
</body>
</html>
