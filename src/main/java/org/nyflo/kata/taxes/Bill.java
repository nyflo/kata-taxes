package org.nyflo.kata.taxes;

import java.math.BigDecimal;
import java.util.List;

public class Bill {

    private final int cartId;
    private final List<Order> orders;
    private final BigDecimal taxes;
    private final BigDecimal totalPrice;

    public Bill(int cartId, List<Order> orders) {
        this.cartId = cartId;
        this.orders = orders;
        this.taxes = orders.stream().map(Order::getTaxes).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        this.totalPrice = orders.stream().map(Order::getPriceWithTax).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public static Bill of(int cartId, List<Order> orders) {
        return new Bill(cartId, orders);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "cartId=" + cartId +
                ", orders=" + orders +
                ", taxes=" + taxes +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public BigDecimal getTaxes() {
        return taxes;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
