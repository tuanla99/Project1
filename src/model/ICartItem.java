package model;

import java.sql.SQLException;
import java.util.List;

public interface ICartItem {
    void insert(CartItem cartItem) throws SQLException;

    void edit(CartItem cartItem)throws SQLException;

    void delete(int id)throws SQLException;

    CartItem get(int id)throws SQLException;

    List<CartItem> getAll()throws SQLException;

    List<CartItem> search(String name)throws SQLException;
}
