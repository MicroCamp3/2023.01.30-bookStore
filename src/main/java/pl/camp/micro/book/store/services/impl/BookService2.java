package pl.camp.micro.book.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.camp.micro.book.store.database.IBookDAO;
import pl.camp.micro.book.store.model.Book;
import pl.camp.micro.book.store.services.IBookService;

import java.util.List;

public class BookService2 implements IBookService {
    @Autowired
    IBookDAO bookRepository;

    @Override
    public List<Book> getBooks() {
        System.out.println("Nowa logika !!!");
        return this.bookRepository.getBooks();
    }
}
