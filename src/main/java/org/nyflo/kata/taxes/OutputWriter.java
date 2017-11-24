package org.nyflo.kata.taxes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OutputWriter {

    public static void write(Path outputFile, Bill bill) {

        try {
            Files.write(outputFile, toLines(bill));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Cannot write into file %s", outputFile.toAbsolutePath()));
        }
    }

    private static List<String> toLines(Bill bill) {


        return null;
    }
}
