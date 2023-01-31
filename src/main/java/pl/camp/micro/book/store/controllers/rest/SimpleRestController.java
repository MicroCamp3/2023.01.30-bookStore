package pl.camp.micro.book.store.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.micro.book.store.model.Book;
import pl.camp.micro.book.store.model.User;

@RestController
public class SimpleRestController {

    @RequestMapping(path = "/rest1", method = RequestMethod.GET)
    public void rest1() {
        System.out.println("cos");
    }

    @RequestMapping(path = "/rest2", method = RequestMethod.GET)
    public Book rest2() {
        return new Book(1, "Inna nazwa ksiazki", "Autor 1", 45.45, 14);
        /*return new Book().id(5)
                .title("Jakas ksiazka").author("Autor 1")
                .price(45.45).quantity(14);*/
    }

    @RequestMapping(path = "/rest3", method = RequestMethod.POST)
    public User rest3(@RequestBody Book book) {
        System.out.println(book);
        return new User(1, "janusz", "kowalski");
    }

    @RequestMapping(path = "/adres/{parametr1}/{parametr2}", method = RequestMethod.PUT)
    public User adres(@PathVariable String parametr1,
                      @PathVariable String parametr2,
                      @RequestParam(required = false) String queryparam1,
                      @RequestParam String queryparam2,
                      @RequestBody(required = false) Book book,
                      @RequestHeader(value = "header1", required = false) Integer innaNazwaHeadera,
                      @RequestHeader String header2) {
        System.out.println(parametr1);
        System.out.println(parametr2);
        System.out.println(queryparam1);
        System.out.println(queryparam2);
        System.out.println(book);
        System.out.println(innaNazwaHeadera);
        System.out.println(header2);

        User user = new User(1, "zbyszek", "malinowski");
        return user;
    }

    @RequestMapping(path = "/rest4", method = RequestMethod.DELETE)
    public ResponseEntity<User> rest4() {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("h1", "v1")
                .header("h2", "v2")
                .header("Content-Type", "application/xml")
                .body(new User(1234, "zbyszek", "ziemba"));
    }
}
