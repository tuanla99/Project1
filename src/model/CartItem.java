package model;

public class CartItem {
    private int id;
    private int soLuong;
    private float gia;
    private Product product;
    private Cart cart;

    public CartItem(){super();}

    public CartItem(int id, int soLuong, float gia, Product product, Cart cart) {
        super();
        this.id = id;
        this.soLuong = soLuong;
        this.gia = gia;
        this.product = product;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
