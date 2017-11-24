package org.nyflo.kata.taxes.domain;

import org.junit.Test;
import org.nyflo.kata.taxes.domain.ProductType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.nyflo.kata.taxes.domain.ProductType.*;

public class ProductTypeTest {

    @Test
    public void shouldDetectBook() {
        assertThat(ProductType.of("livre")).isEqualTo(BOOK);
    }

    @Test
    public void shouldDetectMedicine() {
        assertThat(ProductType.of("pilule contre la migraine")).isEqualTo(MEDICINE);
    }

    @Test
    public void shouldDetectFood() {
        assertThat(ProductType.of("barre de chocolat")).isEqualTo(FOOD);
    }

    @Test
    public void shouldDetectOther() {
        assertThat(ProductType.of("CD musical")).isEqualTo(OTHER_PRODUCT);
    }

}