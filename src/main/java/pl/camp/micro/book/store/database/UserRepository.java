package pl.camp.micro.book.store.database;

import org.springframework.stereotype.Component;
import pl.camp.micro.book.store.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        this.users.add(new User(1, "admin", "21232f297a57a5a743894a0e4a801fc3"));
        this.users.add(new User(2, "janusz", "087d9c5e13bdd64a82bef8e013625c32"));
    }

    public Optional<User> getUserByLogin(final String login) {
        return this.users.stream().filter(u -> u.getLogin().equals(login)).findAny();
    }
}
