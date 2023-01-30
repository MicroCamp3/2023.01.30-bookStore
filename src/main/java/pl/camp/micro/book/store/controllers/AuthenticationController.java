package pl.camp.micro.book.store.controllers;

import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.micro.book.store.database.UserRepository;
import pl.camp.micro.book.store.model.User;
import pl.camp.micro.book.store.session.SessionObject;

import java.util.Optional;

@Controller
@Log4j2
public class AuthenticationController {
    @Autowired
    UserRepository userRepository;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("userModel", new User());
        model.addAttribute("sessionObject", this.sessionObject);
        log.info("logi");
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login2(@ModelAttribute User user) {
        Optional<User> userFromDB = this.userRepository.getUserByLogin(user.getLogin());
        if(userFromDB.isPresent() &&
                userFromDB.get().getPassword()
                        .equals(DigestUtils.md5Hex(user.getPassword()))) {
            this.sessionObject.setUser(userFromDB.get());
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.sessionObject.setUser(null);
        return "redirect:/login";
    }
}
