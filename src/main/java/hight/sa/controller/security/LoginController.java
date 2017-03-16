package hight.sa.controller.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by neron.liu on 09/03/2017.
 */
@Controller
public class LoginController {

    @GetMapping(value = {"/", "/login"})
    public String login(HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return "login";
    }

}
