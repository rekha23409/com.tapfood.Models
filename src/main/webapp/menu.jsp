<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.tapfood.Model.Menu"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style>
    body {
        background-color: #f4f4f9;
        font-family: Arial, sans-serif;
        color: #333333;
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        color: #4a90e2;
        padding: 20px 0;
        margin: 0;
    }

    .menu-container {
        max-width: 1200px;
        margin: 0 auto;
        padding: 20px;
    }

    .menu-item {
        border: 1px solid #cccccc;
        border-radius: 10px;
        margin-bottom: 20px;
        padding: 20px;
        background-color: #ffffff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .menu-item img {
        max-width: 100%;
        border-radius: 10px;
    }

    .menu-item h3 {
        color: #4a90e2;
        margin: 10px 0;
    }

    .menu-item p {
        margin: 10px 0;
        color: #555555;
    }

    .quantity-input {
        width: 60px;
        padding: 5px;
        border: 1px solid #dddddd;
        border-radius: 5px;
        margin-right: 10px;
    }

    .add-to-cart-btn {
        background-color: #4a90e2;
        color: #ffffff;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .add-to-cart-btn:hover {
        background-color: #357ABD;
    }

    .menu-item form {
        display: flex;
        align-items: center;
        margin-top: 10px;
    }
</style>
</head>
<body>
    <h1>Menu</h1>
    <div class="menu-container">
        <%
        List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
        if (menuList != null && !menuList.isEmpty()) {
            for (Menu menuItem : menuList) {
        %>
        <div class="menu-item">
            <img src="/images/<%= menuItem.getImagepath() %>" alt="Image of <%= menuItem.getMenuname() %>">
            <h3><%= menuItem.getMenuname() %></h3>
            <p><%= menuItem.getDescription() %></p>
            <p>Price: <%= menuItem.getPrice() %></p>
            <form action="Cart" method="post">
                <input type="hidden" name="itemId" value="<%= menuItem.getMenuid() %>">
                Quantity: 
                <input type="number" name="quantity" value="1" min="1" class="quantity-input"> 
                <input type="submit" value="Add to Cart" class="add-to-cart-btn"> 
                <input type="hidden" name="action" value="add">
            </form>
        </div>
        <%
            }
        } else {
        %>
        <p>No menu items available.</p>
        <%
        }
        %>
    </div>
</body>
</html>
