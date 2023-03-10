package pl.camp.micro.book.store.database.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.camp.micro.book.store.database.IBookDAO;
import pl.camp.micro.book.store.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IBookDAO {
    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        this.books.add(new Book(1, "Ksiazka 1", "Autor 1", 40.00, 10));
        this.books.add(new Book(2, "Ksiazka 2", "Autor 2", 45.00, 10));
        this.books.add(new Book(3, "Ksiazka 3", "Autor 3", 23.00, 10));
        this.books.add(new Book(4, "Ksiazka 4", "Autor 4", 34.00, 10));
        this.books.add(new Book(5, "Ksiazka 5", "Autor 5", 65.00, 10));
    }

    public List<Book> getBooks() {
        return books;
    }
}
