package org.nyflo.kata.taxes;

public class Product {

    private final int quantity;
    private final String productLabel;
    private final double priceTtc;

    public Product(int quantity, String productLabel, double priceTtc) {
        this.quantity = quantity;
        this.productLabel = productLabel;
        this.priceTtc = priceTtc;
    }

    public static Product of(int quantity, String productLabel, double priceTTC) {
        return new Product(quantity, productLabel, priceTTC);
    }

    @Override
    public String toString() {
        return "Product{" +
                "quantity=" + quantity +
                ", productLabel='" + productLabel + '\'' +
                ", priceTtc=" + priceTtc +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPriceTtc() {
        return priceTtc;
    }

    public String getProductLabel() {
        return productLabel;
    }

}
