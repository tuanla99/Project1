package controller;

import model.Product;
import servise.ProductService;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/detailProduct")
public class DetailProductController extends HttpServlet {
    ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maSP = req.getParameter("maSP");
        Product product = productService.getProduct(Integer.parseInt(maSP));
        req.setAttribute("product", product);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/view/product-detail.jsp");
        dispatcher.forward(req, resp);

    }
}
