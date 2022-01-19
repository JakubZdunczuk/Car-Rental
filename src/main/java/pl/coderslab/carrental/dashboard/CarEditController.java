package pl.coderslab.carrental.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.carrental.car.Car;
import pl.coderslab.carrental.car.CarService;

@Controller
@RequestMapping("dashboard/cars")
public class CarEditController {
    private final CarService carService;

    public CarEditController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping
    public String carList(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "dashboardCarList";
    }

    @RequestMapping("/{id}")
    public String price(@PathVariable("id") String id, Model model) {
        long idL = Long.parseLong(id);
        model.addAttribute("car", carService.findById(idL));
        return "price";
    }

    @PostMapping("/{id}")
    public String pricePost(@PathVariable("id") String id, Car car) {
        long idL = Long.parseLong(id);
        Car carId = carService.findById(idL);
        carId.setPrice(car.getPrice());
        carId.setPromotion(car.getPromotion());
        carService.saveCar(carId);
        return "redirect:../cars";
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteCar(@PathVariable String id) {
        long idL = Long.parseLong(id);
        Car car = carService.findById(idL);
        carService.delete(car);
        return "redirect:../../cars";
    }
}
