package org.nyflo.kata.taxes;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TaxesComputer {

    public static void main(String[] args) {

        Path inputFile = Paths.get(args[0]);

        Cart cart = InputReader.read(inputFile);

        Bill bill = computeBill(cart);

        OutputWriter.write(outputFile(inputFile, cart), bill);
    }

    private static Bill computeBill(Cart cart) {
        return Bill.of(cart.getId(), cart.getOrders());
    }

    private static Path outputFile(Path inputFile, Cart cart) {
        return inputFile.toAbsolutePath().getParent()
                .resolve(
                        "output-"+ cart.getId() + ".txt"
                );
    }

}
