package org.nyflo.kata.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tax {

    private static final BigDecimal rounder = new BigDecimal(0.05);

    public static BigDecimal roundUp(BigDecimal amount) {
        return amount
                .divide(rounder, 0, RoundingMode.UP)
                .multiply(rounder)
                .setScale(2, RoundingMode.DOWN);
    }

}
