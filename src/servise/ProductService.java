package servise;

import database.ProductDB;
import model.IProduct;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProduct {
    ProductDB productDB = new ProductDB();

    @Override
    public List<Product> getAll()  {
        return productDB.getAll();
    }

    @Override
    public void addProduct(Product product)   {
        productDB.addProduct(product);
    }

    @Override
    public void editProduct(Product product)   {
        productDB.editProduct(product);
    }

    @Override
    public void deleteProduct(Product product)   {
        productDB.deleteProduct(product);
    }

    @Override
    public List<Product> searchProductByName(String productName)   {
        return productDB.searchProductByName(productName);
    }

    @Override
    public List<Product> searchProductByNhaXS(String nhaSX)   {
        return productDB.searchProductByNhaXS(nhaSX);
    }

    @Override
    public Product getProduct(int id)   {
        return productDB.getProduct(id);
    }

    @Override
    public List<Product> getAll(int begin, int end)  {
        return productDB.getAll(begin, end);
    }
}
