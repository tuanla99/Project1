package model;

import java.sql.SQLException;
import java.util.List;

public interface ICart {
    void insert(Cart cart) throws SQLException;

    void edit(Cart cart)throws SQLException;

    void delete(int id)throws SQLException;

    Cart get(int id)throws SQLException;

    List<Cart> getAll()throws SQLException;

    List<Cart> search(String name)throws SQLException;
}
