package pl.camp.micro.book.store.database;

import pl.camp.micro.book.store.model.User;

import java.util.Optional;

public interface IUserDAO {
    Optional<User> getUserByLogin(final String login);
}
