package pl.coderslab.car_longrental;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.car_longrental.car.CarService;
import pl.coderslab.car_longrental.users.RoleRepository;
import pl.coderslab.car_longrental.users.User;
import pl.coderslab.car_longrental.users.UserService;

@Controller
public class HomeController {
    private final UserService userService;
    private final CarService carService;

    public HomeController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }

    @RequestMapping("/")
    public String home(Model model) {
   model.addAttribute("car",carService.findByPromotion(1));
        return "index";
    }


    @RequestMapping("/about")
    public String about() {
        return "about";
    }
    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

}
