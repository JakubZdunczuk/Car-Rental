package pl.coderslab.carrental.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.carrental.car.BrandService;
import pl.coderslab.carrental.car.Car;
import pl.coderslab.carrental.car.CarService;
import pl.coderslab.carrental.user.UserService;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {
    private final UserService userService;
    private final CarService carService;
    private final BrandService brandService;

    public DashboardController(UserService userService, CarService carService, BrandService brandService) {
        this.userService = userService;
        this.carService = carService;
        this.brandService = brandService;
    }

    @RequestMapping("/menu")
    public String Menu() {

        return "dashboard";
    }

    @GetMapping("/add")
    public String addNewCar(Model model) {
        model.addAttribute("brandList", brandService.findAll());
        model.addAttribute("car", new Car());
        return "addNewCar";
    }

    @PostMapping("/add")
    public String addNewCarPost(Car car) {
        carService.saveCar(car);
        return "addNewCar";
    }

    @RequestMapping("/carlist")
    public String CarList() {

        return "CarListEdit";
    }

    @RequestMapping("/userlist")
    public String UserList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "UserList";
    }
}
