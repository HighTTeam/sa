package hight.sa.controller.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by neron.liu on 09/03/2017.
 */
@Controller
public class AdminController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/admin")
    public String index(Map<String, Object> model) {
        return "index";
    }

}
