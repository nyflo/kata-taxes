package org.nyflo.kata.taxes;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.nyflo.kata.taxes.ProductType.*;
import static org.nyflo.kata.taxes.Utils.price;

public class VATTest {

    @Test
    public void books_vat_is_zero() {
        assertThat(
            VAT.of(BOOK, price("14.99"))
        ).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void medicine_vat_is_zero() {
        assertThat(
                VAT.of(MEDICINE, price("14.99"))
        ).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void food_vat_is_zero() {
        assertThat(
                VAT.of(FOOD, price("14.99"))
        ).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void should_compute_other_product_vat() {
        assertThat(
                VAT.of(OTHER_PRODUCT, price("14.99"))
        ).isEqualTo(price("1.50"));
    }

}