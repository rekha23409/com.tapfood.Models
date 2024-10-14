package com.tapfood.Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tapfood.DAO.UserDAO;
import com.tapfood.DAOimpl.UserDAOimpl;
import com.tapfood.Model.Users;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	@Override
	 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Retrieve form data
	        String username = request.getParameter("username");
	        String email = request.getParameter("email");
	        String phonenumber = request.getParameter("phonenumber");
	        String password = request.getParameter("password");
	        String address = request.getParameter("address");

	       
	        Users user = new Users();
	        user.setUsername(username);
	        user.setEmail(email);
	        user.setPhonenumber(phonenumber);
	        user.setPassword(password);
	        user.setAddress(address);


	        UserDAO userDao = new UserDAOimpl();
	        int res=userDao.addUsers(user);
                 System.out.println(res);
	        if (res>0) {
	            
	            response.sendRedirect("Succcess.jsp");
	        } 
	        else 
	        {
	            response.sendRedirect("Failure.jsp");
	        }
}
}
