package com.tapfood.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkout") // Make sure this URL matches the form action
public class checkoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get form data
        String address = request.getParameter("address");
        String paymentMode = request.getParameter("paymentmode");

        // Process the data
        System.out.println("Address: " + address);
        System.out.println("Payment Mode: " + paymentMode);
        
        // Forward to a confirmation page
        request.setAttribute("address", address);
        request.setAttribute("paymentMode", paymentMode);
        request.getRequestDispatcher("conformation.jsp").forward(request, response);
    }
}
