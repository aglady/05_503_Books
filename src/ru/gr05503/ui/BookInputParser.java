package ru.gr05503.ui;

import ru.gr05503.domain.Book;

import java.time.LocalDateTime;

public class BookInputParser {
    public ParsedBookInput parse(String author, String title, String year, String information){
        if (author == null || author.isBlank()){
            throw new IllegalArgumentException("не заполнено поле автора");
        }
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("не заполнено поле названия");
        }
        int iYear = getYear(year);
        return  new ParsedBookInput(author, title, iYear, information);
    }
    private int getYear(String year){
        if (year == null || year.isBlank()){
            throw new IllegalArgumentException("не заполнено поле года издания");
        }
        int result;
        try {
            result = Integer.parseInt(year);
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException("неверное число",ex);
        }
        return result;
    }
}
