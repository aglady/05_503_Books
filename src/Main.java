import ru.gr05503.ui.*;

public class Main {
    public static void main(String[] args) {
        BookRepository repository = new InMemoryBookRepository();
        BookService service = new BookService(repository);
        BookPresenter presenter = new BookPresenter(service);
        var wnd = new Window(presenter);
        presenter.setView(wnd);
        wnd.setVisible(true);
        presenter.viewOpened();
    }
}