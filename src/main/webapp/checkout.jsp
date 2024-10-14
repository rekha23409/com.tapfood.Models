<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #e0e0e0;
        color: #444;
        margin: 0;
        padding: 0;
    }

    h2 {
        text-align: center;
        color: #555;
        padding: 20px 0;
        margin: 0;
        background-color: #333;
        color: #fff;
    }

    form {
        background-color: #ffffff;
        padding: 20px;
        margin: 20px auto;
        border-radius: 8px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
        max-width: 400px;
    }

    label {
        font-weight: bold;
        margin-top: 10px;
        display: block;
        color: #333;
    }

    textarea, select {
        width: 100%;
        padding: 12px;
        margin-top: 5px;
        margin-bottom: 20px;
        border: 1px solid #bbb;
        border-radius: 6px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        background-color: #0066cc;
        color: white;
        padding: 14px 0;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        font-size: 18px;
    }

    input[type="submit"]:hover {
        background-color: #005bb5;
    }
</style>
</head>
<body>

<h2>Checkout</h2>
<form action="checkout" method="post"> <!-- This action should match the servlet mapping -->
    <label for="address">Delivery Address:</label>
    <textarea id="address" name="address" required></textarea><br><br>
    
    <label>Payment Method:</label>
    <select name="paymentmode">
        <option value="Credit Card">Credit Card</option>
        <option value="Debit Card">Debit Card</option>
        <option value="Cash On Delivery">Cash On Delivery</option>
    </select><br><br>   
    <input type="submit" value="Place Order">
</form>

</body>
</html>
