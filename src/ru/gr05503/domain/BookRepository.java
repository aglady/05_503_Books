package ru.gr05503.domain;

import java.util.List;

public interface BookRepository {
    void save(Book book);
    List<Book> findAll();
}
