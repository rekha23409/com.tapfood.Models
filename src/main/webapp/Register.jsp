<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    h1 {
        color: #333;
    }

    form {
        background-color: #fff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        width: 100%;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    td {
        padding: 10px;
    }

    input[type="text"],
    input[type="password"],
    input[type="phonenumber"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 10px;
        margin: 10px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    center {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
</style>
</head>
<body>
	<center>
		<h1>Register Here</h1>
		<form action="Register" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" required></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" required></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="phonenumber" name="phonenumber" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
