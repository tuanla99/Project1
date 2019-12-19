package controller;

import model.Product;
import servise.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/searchProductByName")
public class SearchProductByNameController extends HttpServlet {
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Product> products = productService.searchProductByName(name);
        req.setAttribute("productByName",products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/search-ProductByName.jsp");

        dispatcher.forward(req,resp);
    }
}
