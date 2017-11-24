package org.nyflo.kata.taxes.infrastructure;

import org.nyflo.kata.taxes.domain.Cart;
import org.nyflo.kata.taxes.domain.Order;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputReader {

    private static final Pattern headerRegex = Pattern.compile("^#### Input (\\d+)$");
    private static final Pattern productRegex = Pattern.compile("^\\* (\\d+) (.+) à (\\d+.\\d+)$");

    public static Cart read(Path inputFile) {

        try {
            return parseCart(Files.readAllLines(inputFile));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Cannot read file %s", inputFile.toAbsolutePath()));
        }
    }

    public static Cart parseCart(List<String> lines) {
        int cartId = parseHeader(lines.get(0));

        List<Order> orders = lines.stream().skip(1)
                .filter(l -> !l.trim().isEmpty())
                .map(InputReader::parseOrder)
                .collect(Collectors.toList());

        return Cart.of(cartId, orders);
    }

    public static int parseHeader(String headerLine) {
        Matcher matcher = headerRegex.matcher(headerLine);
        if (!matcher.matches())
            throw new IllegalArgumentException(String.format("line '%s' does not match header regex", headerLine));

        int cartId = Integer.parseInt(matcher.group(1));
        return cartId;
    }

    public static Order parseOrder(String line) {

        Matcher matcher = productRegex.matcher(line);
        if (!matcher.matches())
            throw new IllegalArgumentException(String.format("line '%s' does not match product regex", line));

        int quantity = Integer.parseInt(matcher.group(1));
        String label = matcher.group(2);
        BigDecimal price = new BigDecimal(matcher.group(3));
        return Order.of(quantity, label, price);
    }
}
