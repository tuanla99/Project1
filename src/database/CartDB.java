package database;

import connection.ConnectionDB;
import model.Cart;
import model.ICart;
import model.User;
import servise.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDB implements ICart {
    UserService userService = new UserService();
    @Override
    public void insert(Cart cart)  {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="insert into CART values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,cart.getCart_id());
            statement.setInt(2,Integer.parseInt(cart.getBuyer().getMaKH()));
            statement.setDate(3,new Date(cart.getBuyDate().getTime()));
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void edit(Cart cart)  {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="update CART set khachhang_id=?,buyDate=? where cart_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,Integer.parseInt(cart.getBuyer().getMaKH()));
            statement.setInt(3,cart.getCart_id());
            statement.setDate(2,new Date(cart.getBuyDate().getTime()));
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void delete(int id)  {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="delete from CART where cart_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }




    @Override
    public Cart get(int id)  {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="select * from CART,KhachHang where khachhang_id=MaKH;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = userService.getUserBySoDT(resultSet.getString("SoDT"));
                Cart cart = new Cart();
                cart.setCart_id(resultSet.getInt("cart_id"));
                cart.setBuyDate(resultSet.getDate("buyDate"));
                cart.setBuyer(user);
                statement.close();
                return cart;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

       return null;
    }

    @Override
    public List<Cart> getAll()  {
        try {
            List<Cart> cartList = new ArrayList<>();
            Connection connection = ConnectionDB.getConnectionDB();
            Statement statement = connection.createStatement();
            String sql ="select * from KhachHang,CART where khachhang_id=MaKH;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = userService.getUserBySoDT(resultSet.getString("SoDT"));
                Cart cart = new Cart();
                cart.setCart_id(resultSet.getInt("cart_id"));
                cart.setBuyDate(resultSet.getDate("buyDate"));
                cart.setBuyer(user);

                cartList.add(cart);
            }
            statement.close();
            return cartList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Cart> search(String name)  {
        try {
            List<Cart> cartList = new ArrayList<>();
            Connection connection = ConnectionDB.getConnectionDB();
            Statement statement = connection.createStatement();
            String sql ="select * from KhachHang,CART where khachhang_id=MaKH and Email="+name+";";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = userService.getUserBySoDT(resultSet.getString("SoDT"));
                Cart cart = new Cart();
                cart.setCart_id(resultSet.getInt("cart_id"));
                cart.setBuyDate(resultSet.getDate("buyDate"));
                cart.setBuyer(user);

                cartList.add(cart);
            }
            statement.close();
            return cartList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
