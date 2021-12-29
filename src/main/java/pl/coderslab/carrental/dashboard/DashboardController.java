package pl.coderslab.carrental.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.carrental.car.Car;
import pl.coderslab.carrental.car.CarService;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {

private final CarService carService;


    public DashboardController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/add")
    public String addNewCar(Model model) {
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("car", new Car());
        return "addNewCar";
    }
    @PostMapping("/add")
    public String addNewCarPost(Car car) {
        carService.saveCar(car);
        return "addNewCar";
    }

    @RequestMapping("/list")
    public String CarList() {

        return "dashboard/CarList";
    }

    @RequestMapping("/userlist")
    public String UserList() {

        return "dashboard/UserList";
    }
}
