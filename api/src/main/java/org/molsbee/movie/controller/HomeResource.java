package org.molsbee.movie.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j
public class HomeResource {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {
        log.debug("Entering login Controller");
        if (error != null) {
            log.debug("Authentication Failed");
            model.addAttribute("error", "Invalid username and password");
        }
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "add-movie";
    }

}
