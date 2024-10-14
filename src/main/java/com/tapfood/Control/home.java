package com.tapfood.Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.DAO.RestaurantDAO;
import com.tapfood.DAOimpl.RestaurantDAOimpl;
import com.tapfood.Model.Restaurant;

@WebServlet("/home")
public class home extends HttpServlet { 
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	RestaurantDAO restaurantDAO = new RestaurantDAOimpl();
        List<Restaurant> restaurantList = restaurantDAO.getAllRestaurant();
        HttpSession session = req.getSession();
        session.setAttribute("restaurantList", restaurantList); // Updated to match JSP
        res.sendRedirect("home.jsp"); // Ensure this path is correct
    
	}

}
