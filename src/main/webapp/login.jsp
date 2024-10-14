<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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

    center {
        background-color: #ffffff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        max-width: 400px;
        width: 100%;
    }

    h1 {
        color: #333;
        margin-bottom: 20px;
        font-size: 2em;
    }

    table {
        width: 100%;
        margin-bottom: 20px;
    }

    td {
        padding: 10px;
    }

    input[type="text"],
    input[type="password"] {
        width: calc(100% - 22px);
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #1e90ff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 1em;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #1c86ee;
    }

    .error-message {
        color: #ff4d4d;
        margin-bottom: 15px;
    }

    .success-message {
        color: #4caf50;
        margin-bottom: 15px;
    }

    a {
        color: #1e90ff;
        text-decoration: none;
        font-size: 1em;
    }

    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<center>
    <h1>Login Page</h1>
    
    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <% if (errorMessage != null) { %>
        <div class="error-message"><%= errorMessage %></div>
    <% } %>
    
    <% String successMessage = (String) request.getAttribute("successMessage"); %>
    <% if (successMessage != null) { %>
        <div class="success-message"><%= successMessage %></div>
    <% } %>
    
    <form action="login" method="post">
        <table>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Login"></td>
            </tr>
        </table>
    </form>
    
    <a href="Register.jsp">Register me</a>
</center>
</body>
</html>
