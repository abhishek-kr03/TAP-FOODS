<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.food.model.Order"%>
<html>
<head>
<title>Order Confirmation</title>
<link rel="stylesheet" href="CSS/style.css">
<!-- Update with your actual CSS path -->
</head>
<body>
	<h1>Order Confirmation</h1>
	<%
	Order order = (Order) session.getAttribute("order");
	if (order != null) {
	%>
	<div class="order-details">
		<p>Thank you for your order!</p>
		<p>
			Order ID:
			<%=order.getOrderId()%></p>
		<p>
			Total Amount:
			<%=order.getTotalAmount()%></p>
		<p>
			Status:
			<%=order.getStatus()%></p>
		<p>
			Payment Method:
			<%=order.getPaymentMethod()%></p>
		<!-- You can add more details here if needed -->

		<%-- You may also list the items in the order if you have that data --%>
	</div>
	<%
	} else {
	%>
	<p>Order details are not available at the moment.</p>
	<%
	}
	%>
	<a href="home.jsp">Return to Home</a>
</body>
</html>