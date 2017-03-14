package hight.sa.controller.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by neron.liu on 09/03/2017.
 */
@Controller
public class LoginController {

    /*
    @GetMapping("/login")
    public String login(
            HttpSession session) {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {
        if (!StringUtils.startsWith(username, "neron")) {
            model.addAttribute("message", "User not exist!");
            return "login";
        }

        return "index";
    }
    */

}
