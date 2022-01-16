package pl.coderslab.carrental.car;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.carrental.user.RentHistory;
import pl.coderslab.carrental.user.RentHistoryService;
import pl.coderslab.carrental.user.User;
import pl.coderslab.carrental.user.UserService;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping(value = "/cars")
public class CarController {
    private final CarService carService;
    private final RentHistoryService rentHistoryService;
    private final UserService userService;


    public CarController(CarService carService, RentHistoryService rentHistoryService, UserService userService) {
        this.carService = carService;
        this.rentHistoryService = rentHistoryService;
        this.userService = userService;
    }

    @GetMapping
    public String showAllCars(Model model) {
        model.addAttribute("car", carService.findAllByRentedFalse());
        return "carList";
    }

    @GetMapping(value = "/{id}")
    public String showCarById(@PathVariable long id, Model model) {
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        return "showCar";
    }

    @GetMapping(value = "/{id}/rent")
    public String RentCar(@PathVariable long id, Model model) {
        model.addAttribute("rentHistory", new RentHistory());
        model.addAttribute("car", carService.findById(id));
        return "rentCar";
    }

    @PostMapping("{id}/rent")
    public String RentCarPost(@PathVariable long id, RentHistory rentHistory, Model model) {
        Car car = carService.findById(id);

        if (rentHistory.getMonths() == 0) {
            model.addAttribute("rentLength", rentHistory.getDays());
            model.addAttribute("carPrice", car.getPrice());
        } else {
            model.addAttribute("rentLength", rentHistory.getMonths());
            model.addAttribute("carPrice", car.getPrice()*18);
        }
        rentHistory.setCar(car);
        User user = userService.findByUserName(rentHistory.getUser().getUsername());
        rentHistory.setUser(user);
        rentHistory.setRentDay(LocalDate.now());
        rentHistoryService.saveHistory(rentHistory);
        car.setRented(true);
        carService.saveCar(car);

        return "rentAccepted";
    }
}
