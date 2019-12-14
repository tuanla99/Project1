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

@WebServlet(name = "welcome",urlPatterns = "/welcome",loadOnStartup = 1)
public class Welcome extends HttpServlet {
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Product> list = productService.getAll();
            req.setAttribute("pwelcome",list);
            RequestDispatcher dispatcher= req.getRequestDispatcher("/view/client/index.jsp") ;
            dispatcher.forward(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
