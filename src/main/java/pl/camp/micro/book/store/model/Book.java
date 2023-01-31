package pl.camp.micro.book.store.model;

import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
//@Accessors(fluent = true)
public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(double price) {
        this.price = price;
    }

    public void cos() {

    }
}
