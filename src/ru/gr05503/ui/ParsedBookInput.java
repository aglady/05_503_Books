package ru.gr05503.ui;

public record ParsedBookInput(
        String author,
        String title,
        int year,
        String information
) {
}
