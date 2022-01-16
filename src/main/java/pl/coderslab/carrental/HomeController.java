package pl.coderslab.carrental;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.carrental.car.CarService;

@Controller
public class HomeController {

    private final CarService carService;

    public HomeController(CarService carService) {

        this.carService = carService;
    }

    @RequestMapping("/")
    public String home(Model model) {
   model.addAttribute("car",carService.findByRentedFalseAndPromotion(1));
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

    @GetMapping("short")
    public String carsShortTerm(Model model) {
        model.addAttribute("car", carService.findAllByRentedFalse());
        return "shortTerm";
    }

    @GetMapping("long")
    public String carsLongTerm(Model model) {
        model.addAttribute("car", carService.findAllByRentedFalse());
        return "longTerm";
    }
}
