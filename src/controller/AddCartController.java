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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = {"/addCart"})
public class AddCartController extends HttpServlet {
    ProductService productService = new ProductService();
    CartItemService  cartItemService = new CartItemService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String maSP = req.getParameter("maSP");
        String soLuong = req.getParameter("soLuong");
        HttpSession session = req.getSession();
        List<CartItem> cart =(ArrayList<CartItem>) session.getAttribute("cartItem");

        Product product = productService.getProduct(Integer.parseInt(maSP));
        CartItem cartItem = new CartItem();
        cartItem.setGia(product.getGia());
        cartItem.setProduct(product);
        cartItem.setSoLuong(Integer.parseInt(soLuong));
        List<CartItem> cartItems = new ArrayList<>();
        if (!cart.isEmpty() ){
            int tmp = 0; // Kiem tra xem san pham da trong gio hang hay chua?
            for (CartItem item : cart){
                if (item.getProduct().getMaSP() == Integer.parseInt(maSP) ){ // neu san pham da co trong cart thi cong so luong them 1
                    item.setSoLuong(item.getSoLuong()+1);
                    session.setAttribute("card",cart); // them vao session
                    tmp =1;
                    break;
                }
            }
            if (tmp==0){
                cart.add(cartItem);
                session.setAttribute("card",cart); // them vao session
            }
        }else {
            cart.add(cartItem);
            session.setAttribute("card",cart); // them vao session
        }


        resp.sendRedirect(req.getContextPath()+"/cart");
    }
}
