package ru.gr05503.ui;

public class BookPresenter {
    private final BookService service;
    private BookView view;
    public BookPresenter(BookService service) {
        this.service = service;
    }
    public void setView(BookView view) {
        this.view = view;
    }
    public void addBookClicked(){
        try {
            service.addBook(view.getAuthor(), view.getBookTitle(), view.getYear(), view.getInfo());
            view.clearForm();
            view.showBooks(service.getAllBooks());
        } catch(IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }
}
