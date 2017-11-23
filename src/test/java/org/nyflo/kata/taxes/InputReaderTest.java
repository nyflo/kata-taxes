package org.nyflo.kata.taxes;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.nyflo.kata.taxes.InputReader.parseCart;
import static org.nyflo.kata.taxes.InputReader.parseHeader;
import static org.nyflo.kata.taxes.InputReader.parseOrder;

public class InputReaderTest {

    @Test
    public void shouldParseCart() {
        Cart cart = parseCart(
                Arrays.asList(
                        "#### Input 1",
                        "* 1 livre à 12.49",
                        "* 1 CD musical à 14.99",
                        "* 1 barre de chocolat à 0.85"
                )
        );
        assertThat(cart.getId()).isEqualTo(1);
        assertThat(cart.getOrders().size()).isEqualTo(3);
    }

    @Test
    public void shouldParseHeaderLine() {
        String header = "#### Input 1";
        int cartId = parseHeader(header);
        assertThat(cartId).isEqualTo(1);
    }

    @Test
    public void shouldParseProductLine() {
        String line = "* 1 livre à 12.49";
        Order product = parseOrder(line);
        assertThat(product.getQuantity()).isEqualTo(1);
        assertThat(product.getProductLabel()).isEqualTo("livre");
        assertThat(product.getUnitaryPriceWithoutTax().doubleValue()).isEqualTo(12.49);
    }

}