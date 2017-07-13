package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class WelcomeController {
 
    @RequestMapping("/welcome.html")
    public String index(ModelMap model) {
        model.addAttribute("greeting", "index.html from Spring 4MVC");
        return "welcome";
    }
}