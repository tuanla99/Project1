package controller;

import model.CartItem;
import model.Product;
import servise.CartItemService;
import servise.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(urlPatterns = {"/addCart"})
public class AddCartController extends HttpServlet {
    ProductService productService = new ProductService();
    CartItemService  cartItemService = new CartItemService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String maSP = req.getParameter("maSP");
        String soLuong = req.getParameter("soLuong");
        HttpSession session = req.getSession();
       // List<CartItem> cart =(ArrayList<CartItem>) session.getAttribute("cartItem");
        Object o = session.getAttribute("cart");
        Product product = productService.getProduct(Integer.parseInt(maSP));
        CartItem cartItem = new CartItem();
        cartItem.setGia(product.getGia());
        cartItem.setProduct(product);
        cartItem.setSoLuong(Integer.parseInt(soLuong));

        if (o != null ){
            Map<Integer,CartItem> cart = (Map<Integer, CartItem>) o;
            // Kiem tra xem san pham da trong gio hang hay chua?
           CartItem existedCartItem = cart.get(Integer.parseInt(maSP));
            if (existedCartItem == null){
                cart.put(product.getMaSP(),cartItem);
            }else {
                existedCartItem.setSoLuong(existedCartItem.getSoLuong() + Integer.parseInt(soLuong));
            }
            session.setAttribute("cart",cart);
        }else {
           Map<Integer,CartItem> cart = new HashMap<>();
            cart.put(product.getMaSP(),cartItem);
            session.setAttribute("cart",cart);
        }


        resp.sendRedirect(req.getContextPath()+"/list-product");
    }
}
