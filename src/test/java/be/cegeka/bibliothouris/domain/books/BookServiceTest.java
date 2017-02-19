package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jensde on 19/02/2017.
 */
public class BookServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;
    private Book book1, book2;

    @Before
    public void setup() {
         book1 = new Book("Lord");
         book2 = new Book("Harry Potter");
    }

    @Test
    public void getAllBooks_ShouldGetAllBooks() {
        when(bookRepository.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

        List<Book> actual = bookService.getAllBooks();

        Assertions.assertThat(actual).containsOnly(book1, book2);
    }
    @Test
    public void addBook_ShouldAddBook(){
        bookService.addBook("Lord of the rings");

       verify(bookRepository).addBook(new Book("Lord of the rings"));
    }
    @Test
    public void getBookByTitle_ShouldReturnCorrectBook(){
        String title = "Lord";
        when(bookRepository.getBookByTitle(title)).thenReturn(Arrays.asList(book1));

        List<Book> actual = bookService.getBookByTitle(title);

        Assertions.assertThat(actual).isEqualTo(book1);
    }

}