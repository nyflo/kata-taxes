package org.nyflo.kata.taxes.infrastructure;

import org.nyflo.kata.taxes.domain.Bill;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputWriter {

    public static void write(Path outputFile, Bill bill) {

        try {
            Files.write(outputFile, toLines(bill));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Cannot write into file %s", outputFile.toAbsolutePath()));
        }
    }

    private static List<String> toLines(Bill bill) {
        List<String> lines = new ArrayList<>();
        lines.add("#### Output " + bill.getCartId());
        lines.add("");
        lines.addAll(
                bill.getOrders().stream().map(
                        o -> o.getQuantity() + " " + o.getProductLabel() + " : " + o.getPriceWithTax()
                ).collect(Collectors.toList())
        );
        lines.add("Montant des taxes : " + bill.getTaxes());
        lines.add("Total : " + bill.getTotalPrice());

        return lines;
    }
}
