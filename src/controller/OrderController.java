package controller;

import model.Cart;
import model.CartItem;
import model.User;
import servise.CartItemService;
import servise.ProductService;
import servise.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/order")
public class OrderController extends HttpServlet {
    ProductService productService = new ProductService();
    CartItemService cartItemService = new CartItemService();
    CartItem cartItem = new CartItem();
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User buyer = (User) session.getAttribute("account");// Nguoi mua
        Cart cart = new Cart();
        cart.setBuyDate(new java.sql.Date(System.currentTimeMillis()));
        cart.setBuyer(buyer);
        cart.setCart_id(UUID.randomUUID().toString());
        session.removeAttribute("cartItem");// Xoa gio hang
        resp.sendRedirect(req.getContextPath()+"/card"); // Chuyen den trang cart

    }
}
