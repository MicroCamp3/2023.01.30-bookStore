package pl.camp.micro.book.store;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "pl.camp.micro.book.store.controllers",
        "pl.camp.micro.book.store.services.impl",
        "pl.camp.micro.book.store.session"
})
public class TestConfiguration {
}
