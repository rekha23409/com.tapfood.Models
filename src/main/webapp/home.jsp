<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tapfood.Model.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tapfood.Model.Restaurant" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tap Online Food Delivery</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #ECF0F1; /* Light Gray */
        margin: 0;
        padding: 0;
        color: #2C3E50; /* Dark Slate */
    }

    header {
        background-color: #2C3E50; /* Midnight Blue */
        padding: 20px;
        text-align: center;
        color: white;
    }

    header h1 {
        margin: 0;
        font-size: 2.5em;
    }

    header a {
        color: white;
        margin: 0 15px;
        text-decoration: none;
        font-size: 1.1em;
        font-weight: bold;
    }

    header a:hover {
        text-decoration: underline;
    }

    section {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding: 20px;
    }

    section img {
        max-width: 100%;
        height: auto;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        margin-bottom: 10px;
    }

    section h3 {
        font-size: 1.5em;
        color: #2C3E50; /* Match the header color */
        margin: 10px 0;
    }

    section p {
        font-size: 1.1em;
        color: #7F8C8D; /* Grayish Blue */
        margin: 5px 0;
    }

    section a {
        display: inline-block;
        margin-top: 10px;
        padding: 10px 20px;
        background-color: #E74C3C; /* Tomato Red */
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }

    section a:hover {
        background-color: #C0392B; /* Darker Red */
    }

    section > div {
        margin: 15px;
        text-align: center;
        max-width: 300px;
    }

    footer {
        background-color: #34495E; /* Wet Asphalt */
        color: white;
        text-align: center;
        padding: 10px 0;
        position: fixed;
        bottom: 0;
        width: 100%;
    }

    footer p {
        margin: 0;
        font-size: 1em;
    }
</style>
</head>
<body>
    <header>
        <h1>Welcome To Andhra Spicy Online Food Delivery</h1>
        <a href="home">Home</a>
        <% 
        Users user = (Users) session.getAttribute("user");
        if (user != null) {
        %>
        <h3>Welcome back, <%= user.getUsername() %></h3>
        <a href="cart">View Cart</a>
        <a href="OrderHistory">View Order History</a>
        <a href="logout">Logout</a>
        <% 
        } else { %>
        <a href="login.jsp">Login</a>
        <a href="Register.jsp">Register</a>
        <% 
        } 
        %>
    </header>

    <section>
        <%
        List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");
        if (restaurantList != null) {
            for (Restaurant restaurant : restaurantList) {
        %>
        <div>
            <img src="/images/<%= restaurant.getImagepath() %>" alt="Image of <%= restaurant.getRestaurantname() %>">
            <h3><%= restaurant.getRestaurantname() %></h3>
            <p><%= restaurant.getDeliverytime() %> min</p>
            <a href="menu?restaurantid=<%= restaurant.getRestaurantid() %>">View Menu</a>
        </div>
        <% 
            }
        } else { 
        %>
        <p>No restaurants available at the moment.</p>
        <% 
        } 
        %>
    </section>

    <footer>
        <p>&copy; 2024 Tap Food Delivery</p>
    </footer>
</body>
</html>
