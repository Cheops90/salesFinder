package implementation.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }
}
