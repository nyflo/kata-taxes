package org.nyflo.kata.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Order {

    private final int quantity;
    private final String productLabel;
    private final BigDecimal unitaryPriceWithoutTax;

    private final BigDecimal taxes;
    private final BigDecimal priceWithTax;
    private final ProductType productType;

    public Order(int quantity, String productLabel, BigDecimal unitaryPriceWithoutTax) {
        this.quantity = quantity;
        this.productLabel = productLabel;
        this.unitaryPriceWithoutTax = unitaryPriceWithoutTax;

        this.productType = ProductType.of(productLabel);

        BigDecimal quantityBD = BigDecimal.valueOf(quantity);
        this.taxes = quantityBD.multiply(
                VAT.of(productType, unitaryPriceWithoutTax).add(
                        ImportTax.of(productLabel, unitaryPriceWithoutTax)
                )
        );
        this.priceWithTax = unitaryPriceWithoutTax.multiply(quantityBD).add(taxes).setScale(2, RoundingMode.DOWN);
    }

    public static Order of(int quantity, String productLabel, BigDecimal priceTTC) {
        return new Order(quantity, productLabel, priceTTC);
    }

    @Override
    public String toString() {
        return "Order{" +
                "quantity=" + quantity +
                ", productLabel='" + productLabel + '\'' +
                ", unitaryPriceWithoutTax=" + unitaryPriceWithoutTax +
                ", taxes=" + taxes +
                ", priceWithTax=" + priceWithTax +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductLabel() {
        return productLabel;
    }

    public BigDecimal getUnitaryPriceWithoutTax() {
        return unitaryPriceWithoutTax;
    }

    public BigDecimal getTaxes() {
        return taxes;
    }

    public BigDecimal getPriceWithTax() {
        return priceWithTax;
    }
}
