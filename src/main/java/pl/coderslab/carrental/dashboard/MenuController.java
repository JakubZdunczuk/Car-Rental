package pl.coderslab.carrental.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping()
    public String Menu() {

        return "menu";
    }

    @RequestMapping("/changepass")
    public String Change(Model model) {

        return "changepass";
    }
}
