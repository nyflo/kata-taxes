package org.nyflo.kata.taxes;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.nyflo.kata.taxes.Utils.price;

public class OrderTest {

    @Test
    public void products_should_be_taxed_with_VAT() {
        Order order = Order.of(1, "CD musical", price("14.99"));
        assertThat(order.getTaxes()).isEqualTo(price("1.50"));
        assertThat(order.getPriceWithTax()).isEqualTo(price("16.49"));
    }

    @Test
    public void food_should_not_be_taxed() {
        shouldNotBeTaxed( "barre de chocolat", price("0.85"));
    }

    @Test
    public void pills_should_not_be_taxed() {
        shouldNotBeTaxed( "boîte de pilules contre la migraine", price("9.75"));
    }

    @Test
    public void books_should_not_be_taxed() {
        shouldNotBeTaxed( "livre", price("12.49"));
    }

    private static void shouldNotBeTaxed(String product, BigDecimal price) {
        Order order = Order.of(1, product, price);
        assertThat(order.getTaxes()).isEqualTo(BigDecimal.ZERO);
        assertThat(order.getPriceWithTax()).isEqualTo(price);
    }

}