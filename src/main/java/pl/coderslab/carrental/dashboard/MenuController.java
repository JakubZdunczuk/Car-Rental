package pl.coderslab.carrental.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.carrental.car.Car;
import pl.coderslab.carrental.car.CarService;
import pl.coderslab.carrental.user.RentHistory;
import pl.coderslab.carrental.user.RentHistoryService;
import pl.coderslab.carrental.user.User;
import pl.coderslab.carrental.user.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final RentHistoryService rentHistoryService;
    private final UserService userService;
    private final CarService carService;

    public MenuController(RentHistoryService rentHistoryService, UserService userService, CarService carService) {
        this.rentHistoryService = rentHistoryService;
        this.userService = userService;
        this.carService = carService;
    }

    @RequestMapping()
    public String Menu() {

        return "menu";
    }

    @RequestMapping("/changepass")
    public String Change(Model model) {

        return "changepass";
    }

    @RequestMapping("/actual")
    public String ActualRents(HttpServletRequest servletRequest, Model model) {
        User user = userService.findByUserName(servletRequest.getRemoteUser());
        model.addAttribute("history", rentHistoryService.findAllByRentedTrueAndUser(user));
        return "actual";
    }

    @RequestMapping("/actual/{id}")
    public String ActualRents(@PathVariable long id) {
        RentHistory rentHistory = rentHistoryService.findById(id);
        rentHistory.setRented(false);
        Car car = carService.findById(rentHistory.getCar().getId());
        car.setRented(false);
        rentHistoryService.saveHistory(rentHistory);
        carService.saveCar(car);
        return "redirect:../actual";
    }

    @RequestMapping("/history")
    public String RentHistory(HttpServletRequest servletRequest, Model model) {
        User user = userService.findByUserName(servletRequest.getRemoteUser());
        model.addAttribute("history", rentHistoryService.findAllByUser(user));
        return "rentHistory";
    }
}
