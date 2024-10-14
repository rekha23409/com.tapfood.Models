package com.tapfood.Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.DAO.MenuDAO;
import com.tapfood.DAOimpl.MenuDAOimpl;
import com.tapfood.Model.Menu;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String restaurantidStr = req.getParameter("restaurantid");
        if (restaurantidStr == null || restaurantidStr.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing restaurant ID");
            return;
        }

        try {
            int restaurantid = Integer.parseInt(restaurantidStr);
            MenuDAO menuDAO = new MenuDAOimpl();
            List<Menu> menuList = menuDAO.getMenu(restaurantid);

            HttpSession session = req.getSession();
            session.setAttribute("menuList", menuList);
            res.sendRedirect("menu.jsp");
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid restaurant ID format");
        } catch (Exception e) {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request");
        }
    }
}
