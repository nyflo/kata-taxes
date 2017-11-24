package org.nyflo.kata.taxes.domain;

import java.math.BigDecimal;

import static org.nyflo.kata.taxes.Utils.price;

public class ImportTax {

    public static final BigDecimal IMPORT_TAX_RATE = new BigDecimal("0.05");

    public static BigDecimal of(String productLabel, BigDecimal unitaryPriceWithoutTax) {

        if (productLabel.contains("importé"))
            return Tax.roundUp(
                    unitaryPriceWithoutTax.multiply(IMPORT_TAX_RATE)
            );

        return price(BigDecimal.ZERO);
    }
}
