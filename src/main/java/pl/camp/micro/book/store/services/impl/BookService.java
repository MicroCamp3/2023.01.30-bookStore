package pl.camp.micro.book.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.camp.micro.book.store.database.IBookDAO;
import pl.camp.micro.book.store.model.Book;
import pl.camp.micro.book.store.services.IBookService;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookDAO bookRepository;

    @Override
    public List<Book> getBooks() {
        return this.bookRepository.getBooks();
    }

    public void setBookRepository(IBookDAO bookRepository) {
        this.bookRepository = bookRepository;
    }
}
