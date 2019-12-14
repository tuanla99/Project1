package model;

import java.sql.Date;

public class Cart {
    private int cart_id;
    private User buyer;
    private Date buyDate;

    public Cart() {
        super();
    }

    public Cart(int cart_id, User buyer, Date buyDate) {
        this.cart_id = cart_id;
        this.buyer = buyer;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}
