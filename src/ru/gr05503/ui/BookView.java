package ru.gr05503.ui;

import java.util.List;

public interface BookView {
    String getAuthor();
    String getBookTitle();
    String getYear();
    String getInfo();
    void clearForm();
    void showBooks(List<Book> books);
    void showError(String message);
}