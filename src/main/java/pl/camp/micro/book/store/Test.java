package pl.camp.micro.book.store;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.micro.book.store.model.Book;

public class Test {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("janusz"));

        Book book = new Book(1,
        "Asd",
        "asdfasd",
        34.34,
        1);

        book.setAuthor("ABC");
        //System.out.println(book.getAuthor());
        book.author("Asdf").title("asd");
        book.author();

        Book.BookBuilder bookBuilder = Book.builder();
        bookBuilder.author("kdsjafhg");


                bookBuilder.id(1);
        /////
        ////
        ///

        bookBuilder.price(23.32);
        bookBuilder.price(100.00);

                bookBuilder.title("asdf");
                /////
        ////
        //
        /////
        Book book1 = bookBuilder
                .build();

        System.out.println(book1);

        Book book2 = bookBuilder.quantity(10).build();
        System.out.println(book2);

        System.out.println(book1 == book2);


    }
}
