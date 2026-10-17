package ru.gr05503.application;

import ru.gr05503.domain.Book;
import ru.gr05503.domain.BookRepository;
import ru.gr05503.ui.ParsedBookInput;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

public class BookService {
    final private BookRepository repository;
    private final Clock clock;
    public BookService(BookRepository repository, Clock clock){
        this.repository = repository;
        this.clock = clock;
    }
    public void addBook(ParsedBookInput parsedBookInput){
        var author = parsedBookInput.author();
        var title = parsedBookInput.title();
        var year = parsedBookInput.year();
        var information = parsedBookInput.information();
        if (year > LocalDateTime.now(clock).getYear()){
            throw new IllegalArgumentException("неверное число");
        }
        Book book = new Book(author, title, year, information);
        repository.save(book);
    }
    public List<Book> getAllBooks(){
        return repository.findAll();
    }
}
