import ru.gr05503.application.BookService;
import ru.gr05503.domain.BookRepository;
import ru.gr05503.infrastructure.InMemoryBookRepository;
import ru.gr05503.ui.*;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        BookRepository repository = new InMemoryBookRepository();
        Clock clock = Clock.systemDefaultZone();
//        Clock clock = Clock.fixed(
//                Instant.parse("2027-01-01T00:00:00Z"),
//                ZoneId.systemDefault()
//        );
        BookService service = new BookService(repository, clock);
        BookInputParser parser = new BookInputParser();
        BookPresenter presenter = new BookPresenter(service, parser);
        var wnd = new Window(presenter);
        presenter.setView(wnd);
        wnd.setVisible(true);
        presenter.viewOpened();
    }
}