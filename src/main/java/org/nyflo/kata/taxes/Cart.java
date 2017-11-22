package org.nyflo.kata.taxes;

import java.util.List;

public class Cart {


    private final int id;
    private final List<Product> products;

    public Cart(int id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public static Cart of(int cartId, List<Product> products) {
        return new Cart(cartId, products);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }

    public int getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

}
