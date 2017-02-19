package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jensde on 19/02/2017.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Inject
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public
    @ResponseBody
    void addBook(@RequestParam(value = "title", required = true) String title){
        bookService.addBook(title);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public
    @ResponseBody
    List<Book> getBookByTitle(@RequestParam("title")String title){
        return bookService.getBookByTitle(title);
    }

}
