<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.tapfood.Model.Cart" %>
<%@ page import="com.tapfood.Model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <style>
    body {
        font-family: 'Roboto', sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 0;
        color: #333;
    }

    div {
        width: 80%;
        margin: 50px auto;
        padding: 30px;
        background-color: #ffffff;
        box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
    }

    h2 {
        text-align: center;
        color: #4CAF50;
        margin-bottom: 30px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #e0e0e0;
    }

    th, td {
        padding: 15px;
        text-align: center;
    }

    th {
        background-color: #4CAF50;
        color: white;
        font-weight: bold;
    }

    td {
        background-color: #f9f9f9;
    }

    td form {
        margin: 0;
    }

    input[type="number"] {
        width: 60px;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 8px 15px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    a {
        display: block;
        margin-top: 30px;
        text-align: center;
        text-decoration: none;
        color: #4CAF50;
        font-weight: bold;
    }

    a:hover {
        text-decoration: underline;
    }

    p {
        text-align: center;
        font-size: 18px;
        margin-top: 40px;
    }

    .checkout-btn {
        display: block;
        width: 100%;
        max-width: 200px;
        margin: 30px auto;
        background-color: #ff9800;
        color: white;
        text-align: center;
        padding: 15px;
        border-radius: 5px;
        font-size: 18px;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s ease;
        text-decoration: none;
    }

    .checkout-btn:hover {
        background-color: #e68a00;
    }

    </style>
</head>
<body>

<div>
    <h2>Your Shopping Cart</h2>
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            out.println("Cart is null.<br>");
        } else {
            out.println("Cart retrieved successfully.<br>");
            if (cart.getItems() == null) {
                out.println("Cart items map is null.<br>");
            } else if (cart.getItems().isEmpty()) {
                out.println("Cart is empty.<br>");
            } else {
                out.println("Items in cart: " + cart.getItems().size() + "<br>");
            }
        }

        if (cart != null && !cart.getItems().isEmpty()) {
    %>
    <table border="1">
        <tr>
            <th>Item Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Actions</th>
        </tr>
        <%
            for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
                CartItem item = entry.getValue();
        %>
        <tr>
            <td><%=item.getRestaurantid() %>
            <td><%= item.getName() %></td>
            <td>$<%= item.getPrice() %></td>
            <td>
                <form action="Cart" method="post" style="display:inline-block;">
                    <input type="hidden" name="itemId" value="<%= item.getItemid() %>">
                    <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1">
                    <input type="hidden" name="action" value="update">
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>
                <form action="Cart" method="post" style="display:inline-block;">
                    <input type="hidden" name="itemId" value="<%= item.getItemid() %>">
                    <input type="hidden" name="action" value="remove">
                    <input type="submit" value="Remove">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="home.jsp">Continue Shopping</a>
    <form action="checkout.jsp" method="post" style="text-align: center; margin-top: 20px;">
        <input type="submit" value="Proceed to Checkout" class="checkout-btn">
    </form>
    <%
        } else {
    %>
    <p>Your cart is empty. <a href="home.jsp">Go back to the menu</a></p>
    <%
        }
    %>
</div>

</body>
</html>
