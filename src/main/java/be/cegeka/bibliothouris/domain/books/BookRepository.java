package be.cegeka.bibliothouris.domain.books;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by jensde on 19/02/2017.
 */
@Named
public class BookRepository {

    private ArrayList<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().matches(getRegex(title)))
                .collect(toList());

    }

    private String getRegex(String unformattedRegex) {
        return ".*"+ unformattedRegex.replace("*" ,".*")+".*";
    }
}
