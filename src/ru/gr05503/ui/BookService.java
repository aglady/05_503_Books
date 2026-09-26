package ru.gr05503.ui;

import java.time.LocalDateTime;

public class BookService {
    final private BookRepository repository;
    public BookService(BookRepository repository){
        this.repository = repository;
    }
    public void addBook(String author, String title, String year, String information){
        if (author == null || author.isBlank()){
            throw new IllegalArgumentException("не заполнено поле автора");
        }
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("не заполнено поле названия");
        }
        if (year == null || year.isBlank()){
            throw new IllegalArgumentException("не заполнено поле года издания");
        }
        int iYear = getYear(year);
        Book book = new Book(author, title, iYear, information);
        repository.save(book);
    }
    private int getYear(String year){
        int result;
        try {
            result = Integer.parseInt(year);
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException("неверное число",ex);
        }
        if (result < 900 || result > LocalDateTime.now().getYear()){
            throw new IllegalArgumentException("неверное число");
        }
        return result;
    }
}
