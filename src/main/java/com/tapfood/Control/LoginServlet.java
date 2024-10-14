package com.tapfood.Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.DAO.UserDAO;
import com.tapfood.DAOimpl.UserDAOimpl;
import com.tapfood.Model.Users;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDAO userDAO = new UserDAOimpl();
		Users user = userDAO.getUser(email);

		if (user != null && password.equals(user.getPassword())) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			req.setAttribute("successMessage", "Login successful! Welcome, " + user.getUsername() + ".");
			req.getRequestDispatcher("home.jsp").forward(req, res);
		} else {
			req.setAttribute("errorMessage", "Invalid email or password. Please try again.");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}
}
