package be.cegeka.bibliothouris.domain.books;

import javax.inject.Named;

/**
 * Created by jensde on 19/02/2017.
 */
public class Book {
    private String title;

    public Book(String title){

        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return title != null ? title.equals(book.title) : book.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}
