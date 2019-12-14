package controller.Admin;

import model.Product;
import servise.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/product/delete")
public class ProductDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        int maSP = Integer.parseInt(req.getParameter("maSP"));
        Product product = productService.getProduct(maSP);
        productService.deleteProduct(product);
        resp.sendRedirect(req.getContextPath() + "/admin/product/list");
    }
}
