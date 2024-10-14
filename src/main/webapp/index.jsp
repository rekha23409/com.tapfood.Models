<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login/Register Links</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f0f2f5;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        text-align: center;
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    a {
        display: inline-block;
        margin: 10px;
        padding: 15px 25px;
        text-decoration: none;
        font-size: 1.2em;
        color: #ffffff;
        background-color: #1e90ff; /* Blue background color */
        border-radius: 5px;
        transition: background-color 0.3s ease, color 0.3s ease;
    }

    a:hover {
        background-color: #1c86ee; /* Slightly darker blue on hover */
        color: #f0f0f0; /* Light color text on hover */
    }
</style>
</head>
<body>
    <div class="container">
        <a href="Register.jsp">Register me</a>
        <a href="login.jsp">Login</a>
    </div>
</body>
</html>
