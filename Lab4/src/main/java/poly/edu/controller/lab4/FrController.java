package poly.edu.controller.lab4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lab4/home")
class FrController {

    @RequestMapping("/index")
    public String index(Model model) {
        return "lab4/home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        return "lab4/about";
    }
}
