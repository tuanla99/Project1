package database;

import connection.ConnectionDB;
import model.IProduct;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB implements IProduct {
    @Override
    public List<Product> getAll()   {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql = " select * from SanPham ; ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Product product = new Product();
                product.setMaSP(resultSet.getInt(1));
                product.setTenSP(resultSet.getString(2));
                product.setNhaSX(resultSet.getString(3));
                product.setGia(resultSet.getFloat(4));
                product.setHinhAnh(resultSet.getString(5));
                product.setManHinh(resultSet.getString(6));
                product.setRam(resultSet.getInt(7));
                product.setChip(resultSet.getString(8));
                product.setRom(resultSet.getInt(9));
                product.setMauSac(resultSet.getString(10));
                products.add(product);
            }
            statement.close();
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void addProduct(Product product)   {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql = "insert into SanPham value (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(2, product.getTenSP());
            statement.setString(3, product.getNhaSX());
            statement.setDouble(4, product.getGia());
            statement.setString(5, product.getHinhAnh());
            statement.setString(6, product.getManHinh());
            statement.setInt(7, product.getRam());
            statement.setString(8, product.getChip());
            statement.setInt(9, product.getRom());
            statement.setString(10, product.getMauSac());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void editProduct(Product product)   {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql = "update SanPham set TenSp=?,NhaSX=?,GiaBan=?,HinhAnh=?,MANHINH=?,RAM=?,CHIP=?,ROM=?,MAUSAC=? where MaSp=? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getTenSP());
            statement.setString(2, product.getNhaSX());
            statement.setDouble(3, product.getGia());
            statement.setString(4, product.getHinhAnh());
            statement.setString(5, product.getManHinh());
            statement.setInt(6, product.getRam());
            statement.setString(7, product.getChip());
            statement.setInt(8, product.getRom());
            statement.setString(9, product.getMauSac());
            statement.setInt(10, product.getMaSP());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteProduct(Product product)  {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql = "delete from SanPham where MaSp=" + product.getMaSP() + ";";
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Product> searchProductByName(String productName) {
        try {
            List<Product> products = new ArrayList<>();
            Connection connection = ConnectionDB.getConnectionDB();
            String sql = "select * from SanPham where TenSp like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + productName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setMaSP(resultSet.getInt(1));
                product.setTenSP(resultSet.getString(2));
                product.setNhaSX(resultSet.getString(3));
                product.setGia(resultSet.getFloat(4));
                product.setHinhAnh(resultSet.getString(5));
                product.setManHinh(resultSet.getString(6));
                product.setRam(resultSet.getInt(7));
                product.setChip(resultSet.getString(8));
                product.setRom(resultSet.getInt(9));
                product.setMauSac(resultSet.getString(10));

                products.add(product);
            }
            statement.close();
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Product> searchProductByNhaXS(String nhaSX)  {
        try {
            List<Product> products = new ArrayList<>();
            Connection connection = ConnectionDB.getConnectionDB();
            String sql = "select * from SanPham where NhaSX like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + nhaSX + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setMaSP(resultSet.getInt(1));
                product.setTenSP(resultSet.getString(2));
                product.setNhaSX(resultSet.getString(3));
                product.setGia(resultSet.getFloat(4));
                product.setHinhAnh(resultSet.getString(5));
                product.setManHinh(resultSet.getString(6));
                product.setRam(resultSet.getInt(7));
                product.setChip(resultSet.getString(8));
                product.setRom(resultSet.getInt(9));
                product.setMauSac(resultSet.getString(10));

                products.add(product);
            }
            statement.close();
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public Product getProduct(int id) {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql = "select * from SanPham where MaSp=" + id + ";";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Product product = new Product();
            while (resultSet.next()) {

                product.setMaSP(resultSet.getInt(1));
                product.setTenSP(resultSet.getString(2));
                product.setNhaSX(resultSet.getString(3));
                product.setGia(resultSet.getFloat(4));
                product.setHinhAnh(resultSet.getString(5));
                product.setManHinh(resultSet.getString(6));
                product.setRam(resultSet.getInt(7));
                product.setChip(resultSet.getString(8));
                product.setRom(resultSet.getInt(9));
                product.setMauSac(resultSet.getString(10));

            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Product> getAll(int begin, int end)  {
        List<Product> products1 = this.getAll();
        List<Product> products2 = new ArrayList<>();
        for (int i=begin; i<= end; i++){
            Product product = new Product();
            product = products1.get(i);
            products2.add(product);
        }
return products2;
    }


}
// đơn hàng, chi tiết hóa hơn.