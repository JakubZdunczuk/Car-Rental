package pl.coderslab.carrental.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.carrental.car.Car;
import pl.coderslab.carrental.car.CarService;

@Controller
@RequestMapping("dashboard/car")
public class CarEditController {
    private final CarService carService;

    public CarEditController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/{id}/price")
    public String price(@PathVariable("id") String id, Model model) {
        long idL = Long.parseLong(id);
        Car car = carService.findById(idL);
        model.addAttribute("price", car.getPrice());
        model.addAttribute("promotion", car.getPromotion());
        return "price";
    }
    @PostMapping("/{id}/price")
    public String pricePost(@PathVariable("id") String id, Model model) {
        long idL = Long.parseLong(id);
        Car car = carService.findById(idL);
        return "price";
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteCar(@PathVariable String id) {
        long idL = Long.parseLong(id);
        Car car = carService.findById(idL);
        carService.delete(car);
        return "redirect:";
    }
}
