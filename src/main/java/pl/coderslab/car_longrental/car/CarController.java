package pl.coderslab.car_longrental.car;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String showAllCars(Model model) {
      model.addAttribute("car", carService.findAll());
      return "carList";
    }
    @GetMapping(value = "/{id}")
    public String showCarById(@PathVariable long id, Model model) {
        Car car=carService.findById(id);
        model.addAttribute("car", car);
        return "showCar";
    }

    @GetMapping(value = "/{id}/rent")
    public String RentCar(@PathVariable long id, Model model) {
        model.addAttribute("car", carService.findById(id));
        return "rentCar";
    }
}
