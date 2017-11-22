package org.nyflo.kata.taxes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputReader {

    private static final Pattern headerRegex = Pattern.compile("^#### Input (\\d+)$");
    private static final Pattern productRegex = Pattern.compile("^\\* (\\d+) ([\\w|\\s]+) à (\\d+.\\d+)$");

    public static Cart read(Path inputFile) {

        List<String> lines;
        try {
            return parseCart(Files.readAllLines(inputFile));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Cannot read file %s", inputFile.toAbsolutePath()));
        }
    }

    public static Cart parseCart(List<String> lines) {
        int cartId = parseHeader(lines.get(0));

        List<Product> products = lines.stream().skip(1)
                .filter(l -> !l.trim().isEmpty())
                .map(InputReader::parseProduct)
                .collect(Collectors.toList());

        return Cart.of(cartId, products);
    }

    public static int parseHeader(String headerLine) {
        Matcher matcher = headerRegex.matcher(headerLine);
        if (!matcher.matches())
            throw new IllegalArgumentException(String.format("line '%s' does not match header regex", headerLine));

        int cartId = Integer.parseInt(matcher.group(1));
        return cartId;
    }

    public static Product parseProduct(String line) {

        Matcher matcher = productRegex.matcher(line);
        if (!matcher.matches())
            throw new IllegalArgumentException(String.format("line '%s' does not match product regex", line));

        int quantity = Integer.parseInt(matcher.group(1));
        String label = matcher.group(2);
        double price = Double.parseDouble(matcher.group(3));
        return Product.of(quantity, label, price);
    }
}
