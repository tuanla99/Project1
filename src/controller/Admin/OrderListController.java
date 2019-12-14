package controller.Admin;

import model.CartItem;
import servise.CartItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/order/list")
public class OrderListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartItemService cartItemService = new CartItemService();
        List<CartItem> cartItems = cartItemService.getAll();
        req.setAttribute("cartItems",cartItems);
        req.getRequestDispatcher("/view/admin/list-order.jsp").forward(req,resp);
    }
}
