package org.nyflo.kata.taxes.domain;

import java.util.Arrays;
import java.util.List;

public enum ProductType {

    BOOK("livre"),
    FOOD("chocolat"),
    MEDICINE("pilule"),
    OTHER_PRODUCT();

    private final List<String> keywords;

    ProductType(String... keywords) {
        this.keywords = Arrays.asList(keywords);
    }

    public static ProductType of(String productLabel) {
        return Arrays.stream(values()).filter(
                e -> e.keywords.stream().anyMatch(k -> productLabel.contains(k))
        ).findFirst().orElse(OTHER_PRODUCT);
    }
}
