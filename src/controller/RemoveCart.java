package controller;

import model.CartItem;
import servise.CartItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/removeCart")

public class RemoveCart extends HttpServlet {
    CartItemService cartItemService = new CartItemService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItem");
        String id = req.getParameter("id");
        CartItem cartItem = cartItemService.get(Integer.parseInt(id));

        cartItems.remove(cartItem);
        session.setAttribute("cartItem",cartItems);
        resp.sendRedirect(req.getContextPath()+"/cart");
    }
}
