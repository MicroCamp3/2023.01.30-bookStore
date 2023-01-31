package pl.camp.micro.book.store.services.impl;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.camp.micro.book.store.database.IUserDAO;
import pl.camp.micro.book.store.exceptions.IncorrectAuthenticationException;
import pl.camp.micro.book.store.model.User;
import pl.camp.micro.book.store.services.IAuthenticationService;
import pl.camp.micro.book.store.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    IUserDAO userRepository;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> userFromDB = this.userRepository.getUserByLogin(login);
        if(userFromDB.isEmpty() ||
                !userFromDB.get().getPassword()
                        .equals(DigestUtils.md5Hex(password))) {
            throw new IncorrectAuthenticationException();
        }
        this.sessionObject.setUser(userFromDB.get());
    }

    @Override
    public void logout() {
        this.sessionObject.setUser(null);
    }
}
