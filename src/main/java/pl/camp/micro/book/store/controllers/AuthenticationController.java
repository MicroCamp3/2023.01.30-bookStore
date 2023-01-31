package pl.camp.micro.book.store.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.micro.book.store.exceptions.IncorrectAuthenticationException;
import pl.camp.micro.book.store.exceptions.UserValidationException;
import pl.camp.micro.book.store.model.User;
import pl.camp.micro.book.store.services.IAuthenticationService;
import pl.camp.micro.book.store.session.SessionObject;
import pl.camp.micro.book.store.validators.UserDataValidator;

import javax.annotation.Resource;

@Controller
@Log4j2
public class AuthenticationController {
    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("userModel", new User());
        model.addAttribute("sessionObject", this.sessionObject);
        log.trace("logi");
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login2(@ModelAttribute User user) {
        try {
            UserDataValidator.validateLogin(user.getLogin());
            UserDataValidator.validatePassword(user.getPassword());
            this.authenticationService.authenticate(user.getLogin(), user.getPassword());
            return "redirect:/";
        } catch (UserValidationException | IncorrectAuthenticationException e) {
            return "redirect:/login";
        }
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.authenticationService.logout();
        return "redirect:/login";
    }
}
