package servise;

import model.CartItem;
import model.ICartItem;

import java.sql.SQLException;
import java.util.List;

public class CartItemService implements ICartItem {
    CartItemService cartItemService = new CartItemService();
    @Override
    public void insert(CartItem cartItem)  {
        cartItemService.insert(cartItem);
    }

    @Override
    public void edit(CartItem cartItem)  {
        cartItemService.edit(cartItem);
    }

    @Override
    public void delete(int id)  {
        cartItemService.delete(id);
    }

    @Override
    public CartItem get(int name) {
        return cartItemService.get(name);
    }



    @Override
    public List<CartItem> getAll()  {
        return cartItemService.getAll();
    }

    @Override
    public List<CartItem> search(String name)  {
        return cartItemService.search(name);
    }
}
