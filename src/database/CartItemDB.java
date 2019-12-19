package database;

import connection.ConnectionDB;
import model.Cart;
import model.CartItem;
import model.ICartItem;
import model.Product;
import servise.CartService;
import servise.ProductService;
import servise.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartItemDB implements ICartItem {
        CartService cartService = new CartService();
        ProductService productService = new ProductService();
        UserService userService = new UserService();
    @Override
    public void insert(CartItem cartItem)  {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql =" insert into CartItem values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,cartItem.getId());
            statement.setInt(2,cartItem.getSoLuong());
            statement.setFloat(3,cartItem.getGia());
            statement.setInt(4,cartItem.getProduct().getMaSP());
            statement.setInt(5,cartItem.getCart().getCart_id());
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void edit(CartItem cartItem)  {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql =" update  CartItem set SoLuong=?,Gia=?,MaSP=?,CartID=? where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,cartItem.getId());
            statement.setInt(1,cartItem.getSoLuong());
            statement.setFloat(2,cartItem.getGia());
            statement.setInt(3,cartItem.getProduct().getMaSP());
            statement.setInt(4,cartItem.getCart().getCart_id());
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql =" delete from CartItem where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }



    @Override
    public CartItem get(int id)  {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="select * from CartItem,CART,SanPham where CART.cart_id=CartItem.CartID and CartItem.MaSP=MaSp and id=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            CartItem cartItem = new CartItem();
            while (resultSet.next()){

                cartItem.setId(resultSet.getInt("CartID"));
                cartItem.setSoLuong(resultSet.getInt("SoLuong"));
                cartItem.setGia(resultSet.getFloat("Gia"));

                Product product = new Product();
                product=productService.getProduct(resultSet.getInt("MaSP"));

                Cart cart = new Cart();
                cart= cartService.get(resultSet.getInt("CART.CartID"));

                cartItem.setProduct(product);
                cartItem.setCart(cart);
                statement.close();

            }  return  cartItem;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public List<CartItem> getAll() {
        try {
            List<CartItem> cartItemList = new ArrayList<>();
            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="select * from CartItem,CART,SanPham where CART.cart_id=CartItem.CartID and CartItem.MaSP=MaSp;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                CartItem cartItem = new CartItem();
                cartItem.setId(resultSet.getInt("CartID"));
                cartItem.setSoLuong(resultSet.getInt("SoLuong"));
                cartItem.setGia(resultSet.getFloat("Gia"));

                Product product = new Product();
                product=productService.getProduct(resultSet.getInt("MaSP"));

                Cart cart = new Cart();
                cart= cartService.get(resultSet.getInt("CART.CartID"));

                cartItem.setProduct(product);
                cartItem.setCart(cart);

                cartItemList.add(cartItem);

            }
            statement.close();
            return cartItemList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }



    }

    @Override
    public List<CartItem> search(String name) {
        return null;
    }
}
