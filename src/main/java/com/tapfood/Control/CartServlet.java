package com.tapfood.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.DAO.MenuDAO;
import com.tapfood.DAOimpl.MenuDAOimpl;
import com.tapfood.Model.Cart;
import com.tapfood.Model.Menu;
import com.tapfood.Model.CartItem;

@WebServlet("/Cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
            System.out.println("New Cart created and added to session.");
        } else {
            System.out.println("Cart retrieved from session.");
        }

        String action = req.getParameter("action");
        if ("add".equals(action)) {
            addItemToCart(req, cart);
        } else if ("update".equals(action)) {
            updateCartItem(req, cart);
        } else if ("remove".equals(action)) {
            removeItemFromCart(req, cart);
        }

        session.setAttribute("cart", cart); // Ensure the updated cart is set back to the session
        resp.sendRedirect("cart.jsp");
    }

    private void addItemToCart(HttpServletRequest req, Cart cart) throws ServletException, IOException {
        try {
            int itemId = Integer.parseInt(req.getParameter("itemId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            MenuDAO menuDAO = new MenuDAOimpl();
            Menu menuItem = menuDAO.getMenue(itemId);
            if (menuItem != null) {
                CartItem item = new CartItem(
                    menuItem.getMenuid(),
                    menuItem.getRestaurantid(),
                    menuItem.getMenuname(),
                    
                    quantity, menuItem.getPrice()
                );
                cart.addItem(item);
                System.out.println("Added item: " + item);
            } else {
                System.out.println("Menu item not found for ID: " + itemId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error adding item to cart: " + e.getMessage());
        }
    }

    private void updateCartItem(HttpServletRequest req, Cart cart) throws ServletException, IOException {
        try {
            int itemid = Integer.parseInt(req.getParameter("itemId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            cart.updateItem(itemid, quantity);
            System.out.println("Updated item ID: " + itemid + " to quantity: " + quantity);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error updating item in cart: " + e.getMessage());
        }
    }

    private void removeItemFromCart(HttpServletRequest req, Cart cart) throws ServletException, IOException {
        try {
            int itemId = Integer.parseInt(req.getParameter("itemId"));
            cart.removeItem(itemId);
            System.out.println("Removed item ID: " + itemId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error removing item from cart: " + e.getMessage());
        }
    }
}
