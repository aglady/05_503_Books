import ru.gr05503.ui.*;

public class MainConsole {
    public static void main(String[] args) {
        BookRepository repository = new InMemoryBookRepository();
        BookService service = new BookService(repository);
        BookPresenter presenter = new BookPresenter(service);
        var con = new Console(presenter);
        presenter.setView(con);
        presenter.viewOpened();
    }
}
