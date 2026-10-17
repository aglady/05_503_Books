package ru.gr05503.ui;

import ru.gr05503.domain.Book;

import java.util.List;
import java.util.Scanner;

public class Console implements BookView{
    private String author;
    private String title;
    private String year;
    private String info;
    private final Scanner scanner;
    private final BookPresenter presenter;

    public Console(BookPresenter presenter) {
        scanner = new Scanner(System.in);
        this.presenter = presenter;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getBookTitle() {
        return title;
    }

    @Override
    public String getYear() {
        return year;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void clearForm() {
        author = null;
        title = null;
        year = null;
        info = null;
    }

    @Override
    public void showBooks(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        for (var book : books) {
            sb.append(book.author());
            sb.append(" | ");
            sb.append(book.title());
            sb.append(" | ");
            sb.append("" + book.year());
            if (book.information() != null && !book.information().isBlank()) {
                sb.append(" | ");
                sb.append(book.information());
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    @Override
    public void showError(String message) {
        System.err.println(message);
    }

    @Override
    public void render(BookFormState state) {
        System.out.println(state.status());
        if ( state.error()!= null)
            showError(state.error());
        if (!state.addEnabled())
            requestUserDate();
    }

    private void requestUserDate() {
        System.out.print("Введите автора: ");
        author = scanner.nextLine();
        System.out.print("Введите название: ");
        title = scanner.nextLine();
        System.out.print("Введите год издания: ");
        year = scanner.nextLine();
        System.out.print("Введите допинформацию: ");
        info = scanner.nextLine();
        presenter.addBookClicked();
    }
}
