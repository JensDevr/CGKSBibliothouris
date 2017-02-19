package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by jensde on 19/02/2017.
 */
@Named
public class BookService {
    @Inject
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public void addBook(String title) {
        bookRepository.addBook(new Book(title));
    }

    public List<Book> getBookByTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }
}
