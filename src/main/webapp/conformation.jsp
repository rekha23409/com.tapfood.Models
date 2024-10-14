<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>
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

    .confirmation {
        background-color: #ffffff;
        padding: 20px;
        margin: 20px auto;
        border-radius: 8px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
        max-width: 400px;
    }

    p {
        font-size: 16px;
        line-height: 1.6;
        color: #333;
    }
</style>
</head>
<body>

<h2>Order Confirmed!</h2>
<div class="confirmation">
    <p>Thank you for your order. It will be delivered to:</p>
    <p><strong>Address:</strong> ${address}</p>
    <p><strong>Payment Method:</strong> ${paymentMode}</p>
</div>

</body>
</html>
