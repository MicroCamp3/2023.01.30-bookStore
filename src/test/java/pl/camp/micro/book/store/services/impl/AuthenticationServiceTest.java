package pl.camp.micro.book.store.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.camp.micro.book.store.TestConfiguration;
import pl.camp.micro.book.store.configuration.AppConfiguration;
import pl.camp.micro.book.store.database.IBookDAO;
import pl.camp.micro.book.store.database.IUserDAO;
import pl.camp.micro.book.store.model.User;
import pl.camp.micro.book.store.services.IAuthenticationService;
import pl.camp.micro.book.store.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class AuthenticationServiceTest {

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionObject sessionObject;

    @MockBean
    IBookDAO bookDAO;

    @MockBean
    IUserDAO userDAO;

    @Test
    public void authenticationTest() {
        Mockito.when(this.userDAO.getUserByLogin("admin"))
                .thenReturn(Optional.of(new User(1, "admin", "21232f297a57a5a743894a0e4a801fc3")));
        this.sessionObject.setUser(null);
        this.authenticationService.authenticate("admin", "admin");

        Assertions.assertTrue(this.sessionObject.isLogged());
    }
}
