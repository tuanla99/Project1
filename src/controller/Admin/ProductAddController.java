package controller.Admin;

import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import servise.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/product/add")
public class ProductAddController extends HttpServlet {
    ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/add-product.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        try {
            List<FileItem> fileItems =servletFileUpload.parseRequest(req);
            for (FileItem fileItem: fileItems){
                if (fileItem.getFieldName().equals("tenSP")){
                    product.setTenSP(fileItem.getString());
                }else if(fileItem.getFieldName().equals("nhaSX")){
                    product.setNhaSX(fileItem.getString());
                }else if(fileItem.getFieldName().equals("giaBan")){
                    product.setGia(Float.parseFloat(fileItem.getString()));
                }else if(fileItem.getFieldName().equals("hinhAnh")){
                    final String dir ="D:\\Project1\\WebDienThoai\\web\\view\\admin\\img";
                    String fileName = fileItem.getName();
                    File file = new File(dir +"/"+fileName);
                    fileItem.write(file);
                    product.setHinhAnh(fileName);
                }else if(fileItem.getFieldName().equals("manHinh")){
                    product.setManHinh(fileItem.getString());
                }else if(fileItem.getFieldName().equals("ram")){
                    product.setRam(Integer.parseInt(fileItem.getString()));
                }else if(fileItem.getFieldName().equals("chip")){
                    product.setChip(fileItem.getString());
                }else if(fileItem.getFieldName().equals("rom")){
                    product.setRom(Integer.parseInt(fileItem.getString()));
                }else if(fileItem.getFieldName().equals("mauSac")){
                    product.setMauSac(fileItem.getString());
                }
            }
            productService.addProduct(product);
            resp.sendRedirect(req.getContextPath() + "/admin/product/list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
