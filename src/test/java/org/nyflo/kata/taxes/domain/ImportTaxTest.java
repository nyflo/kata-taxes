package org.nyflo.kata.taxes.domain;

import org.junit.Test;
import org.nyflo.kata.taxes.domain.ImportTax;

import static org.assertj.core.api.Assertions.assertThat;
import static org.nyflo.kata.taxes.Utils.price;

public class ImportTaxTest {

    @Test
    public void imported_products_should_be_taxed() {
        assertThat(ImportTax.of("CD importé", price("10"))).isEqualTo(price("0.50"));
        assertThat(ImportTax.of("boîte de chocolat importée", price("10.99"))).isEqualTo(price("0.55"));
    }

    @Test
    public void non_imported_products_should_not_be_taxed() {
        assertThat(ImportTax.of("CD", price("10"))).isEqualTo(price("0.00"));
    }

}