package ru.gr05503.ui;
import java.util.List;

public interface BookRepository {
    void save(Book book);
    List<Book> findAll();
}
