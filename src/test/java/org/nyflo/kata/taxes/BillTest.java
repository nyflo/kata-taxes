package org.nyflo.kata.taxes;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.nyflo.kata.taxes.Utils.price;

public class BillTest {

    @Test
    public void bill1_should_be_ok() {
        Bill bill = Bill.of(1, Arrays.asList(
                Order.of(1, "livre", price("12.49")),
                Order.of(1, "CD musical", price("14.99")),
                Order.of(1, "barre de chocolat", price("0.85"))
        ));
        assertThat(bill.getTaxes()).isEqualTo(price("1.50"));
        assertThat(bill.getTotalPrice()).isEqualTo(price("29.83"));
    }

    @Test
    public void bill2_should_be_ok() {
        Bill bill = Bill.of(1, Arrays.asList(
                Order.of(1, "boîte de chocolats importée", price("10.00")),
                Order.of(1, "flacon de parfum importé", price("47.50"))
        ));
        assertThat(bill.getTaxes()).isEqualTo(price("7.65"));
        assertThat(bill.getTotalPrice()).isEqualTo(price("65.15"));
    }

    @Test
    public void bill3_should_be_ok() {
        Bill bill3 = Bill.of(1, Arrays.asList(
                Order.of(1, "flacon de parfum importé", price("27.99")),
                Order.of(1, "flacon de parfum", price("18.99")),
                Order.of(1, "boîte de pilules contre la migraine", price("9.75")),
                Order.of(1, "boîte de chocolats importés", price("11.25"))
        ));
        assertThat(bill3.getTaxes()).isEqualTo(price("6.70"));
        assertThat(bill3.getTotalPrice()).isEqualTo(price("74.68"));
    }

}