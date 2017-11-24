package org.nyflo.kata.taxes;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.nyflo.kata.taxes.ProductType.*;

public class VAT {

    public static final BigDecimal VAT_RATE = new BigDecimal("0.10");

    public static BigDecimal of(ProductType productType, BigDecimal unitaryPriceWithoutTax) {

        if (Stream.of(BOOK, FOOD, MEDICINE).anyMatch(t -> t == productType))
            return BigDecimal.ZERO;

        return Tax.roundUp(
                unitaryPriceWithoutTax.multiply(VAT_RATE)
        );
    }

}
