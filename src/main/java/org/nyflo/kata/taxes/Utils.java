package org.nyflo.kata.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

    public static BigDecimal price(String price) {
        return new BigDecimal(price);
    }

    public static BigDecimal price(BigDecimal price) {
        return price.setScale(2, RoundingMode.DOWN);
    }

}
