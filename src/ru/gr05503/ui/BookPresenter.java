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
            view.render(BookFormState.init());
        } catch(IllegalArgumentException e) {
            view.render(BookFormState.setError(e.getMessage()));
        }
    }
    public void viewOpened(){
        view.showBooks(service.getAllBooks());
        view.render(BookFormState.init());
    }

    public void inputChanged(){
        if (isAddAllowed()){
            view.render(BookFormState.setReady());
        } else {
            view.render(BookFormState.init());
        }
    }

    public boolean isAddAllowed(){
        return isNotBlank(view.getAuthor())
                && isNotBlank(view.getBookTitle())
                && isNotBlank(view.getYear());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.isBlank();
    }
}
