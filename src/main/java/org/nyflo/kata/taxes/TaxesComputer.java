package org.nyflo.kata.taxes;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TaxesComputer {

    public static void main(String[] args) {
        Path inputFile = Paths.get(args[0]);

        Cart cart = InputReader.read(inputFile);

        Bill bill = compute(cart);

        OutputWriter.write(outputFile(inputFile), bill);
    }

    private static Bill compute(Cart cart) {
        return null;
    }

    private static Path outputFile(Path inputFile) {
        return null;
    }

}
