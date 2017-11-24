package org.nyflo.kata.taxes.domain;

import org.junit.Test;
import org.nyflo.kata.taxes.domain.Tax;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxTest {

    @Test
    public void shouldRoundUpPrice() {
        shouldRoundUpPrice(0.00, 0.00);
        shouldRoundUpPrice(0.01, 0.05);
        shouldRoundUpPrice(0.04, 0.05);
        shouldRoundUpPrice(0.05, 0.05);

        shouldRoundUpPrice(0.1, 0.1);

        shouldRoundUpPrice(0.98, 1.00);
        shouldRoundUpPrice(0.99, 1.00);
        shouldRoundUpPrice(1, 1);
        shouldRoundUpPrice(1.01, 1.05);
        shouldRoundUpPrice(1.02, 1.05);
    }

    private void shouldRoundUpPrice(double tested, double expected) {
        assertThat(
                Tax.roundUp(new BigDecimal(tested)).doubleValue()
        ).isEqualTo(expected);
    }

}