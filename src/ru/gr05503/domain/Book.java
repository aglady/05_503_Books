package ru.gr05503.domain;

import java.time.LocalDateTime;

public record Book(
        String author,
        String title,
        int year,
        String information) {
    public Book {
        if (author == null || author.isBlank()){
            throw new IllegalArgumentException("не заполнено поле автора");
        }
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("не заполнено поле названия");
        }
        author = author.trim();
        title = title.trim();
        if (year < 900){
            throw new IllegalArgumentException("неверное число");
        }
    }
}
