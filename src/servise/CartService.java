package servise;

import database.CartDB;
import model.Cart;
import model.ICart;

import java.sql.SQLException;
import java.util.List;

public class CartService implements ICart {
    CartDB cartDB = new CartDB();
    @Override
    public void insert(Cart cart)  {
        cartDB.insert(cart);
    }

    @Override
    public void edit(Cart cart)  {
        cartDB.edit(cart);
    }

    @Override
    public void delete(int id)  {
        cartDB.delete(id);
    }




    @Override
    public Cart get(int id)  {
        return cartDB.get(id);
    }

    @Override
    public List<Cart> getAll()  {
        return cartDB.getAll();
    }

    @Override
    public List<Cart> search(String name) {
        return cartDB.search(name);
    }
}
