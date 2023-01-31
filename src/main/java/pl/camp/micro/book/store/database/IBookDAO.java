package pl.camp.micro.book.store.database;

import pl.camp.micro.book.store.model.Book;

import java.util.List;

public interface IBookDAO {
    List<Book> getBooks();
}
