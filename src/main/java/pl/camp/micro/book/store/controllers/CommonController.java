package pl.camp.micro.book.store.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.micro.book.store.services.IBookService;
import pl.camp.micro.book.store.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CommonController {

    @Autowired
    private IBookService bookService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("books", this.bookService.getBooks());
        model.addAttribute("sessionObject", this.sessionObject);
        return "index";
    }

    @RequestMapping(path = "/main", method = RequestMethod.GET)
    public String main() {
        return "redirect:/";
    }

    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("sessionObject", this.sessionObject);
        return "contact";
    }
}
