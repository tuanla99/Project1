package model;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    public List<Product> getAll() throws SQLException;
    public void  addProduct(Product product)  throws SQLException;
    public void editProduct(Product product) throws SQLException; // Sua thong tin san pham.
    public void deleteProduct(Product product) throws SQLException; // Xoa san pham.
    public List<Product> searchProductByName(String productName) throws SQLException; // Tim kiem san pham theo tên.
    public List<Product> searchProductByNhaXS(String nhaSX) throws SQLException; // Tim kiem san pham theo nha sx
    public Product getProduct(int id) throws SQLException; // Lay san pham theo ID
    public List<Product> getAll(int begin, int end) throws SQLException;
}
