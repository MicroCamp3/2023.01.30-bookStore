package pl.camp.micro.book.store.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.camp.micro.book.store.database.IBookDAO;
import pl.camp.micro.book.store.database.impl.BookRepository;
import pl.camp.micro.book.store.services.IBookService;
import pl.camp.micro.book.store.services.impl.BookService;

@Configuration
@ComponentScan("pl.camp.micro.book.store")
public class AppConfiguration {
    /*@Bean
    public IBookDAO bookDAO() {
        return new BookRepository();
    }

    @Bean
    public IBookService bookService(IBookDAO bookDAO) {
        BookService bookService = new BookService();
        bookService.setBookRepository(bookDAO);
        return bookService;
    }*/
}
