package org.nyflo.kata.taxes.domain;

import java.util.List;

public class Cart {


    private final int id;
    private final List<Order> products;

    public Cart(int id, List<Order> products) {
        this.id = id;
        this.products = products;
    }

    public static Cart of(int cartId, List<Order> products) {
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

    public List<Order> getOrders() {
        return products;
    }

}
