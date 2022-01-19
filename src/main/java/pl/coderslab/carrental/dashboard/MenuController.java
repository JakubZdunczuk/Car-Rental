package pl.coderslab.carrental.dashboard;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private final BCryptPasswordEncoder passwordEncoder;
    private final MessageService messageService;


    public MenuController(RentHistoryService rentHistoryService, UserService userService, CarService carService, BCryptPasswordEncoder passwordEncoder, MessageService messageService) {
        this.rentHistoryService = rentHistoryService;
        this.userService = userService;
        this.carService = carService;
        this.passwordEncoder = passwordEncoder;
        this.messageService = messageService;
    }

    @RequestMapping()
    public String Menu() {
        return "menu";
    }

    @RequestMapping("/changepass")
    public String Change(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "changePass";
    }

    @PostMapping("/changepass")
    public String ChangePost(User user, BindingResult result, HttpServletRequest servletRequest) {
        User loggedUser = userService.findByUserName(servletRequest.getRemoteUser());

        if (!passwordEncoder.matches(user.getPassword(), loggedUser.getPassword())) {
            result.rejectValue("password", "error.password", "Hasło nieprawidłowe");
        }
        if (user.getPassword().equals(user.getNewPassword())) {
            result.rejectValue("newPassword", "error.newPassword", "Obecne i nowe hasło są takie same");
        }
        if (!user.getPasswordConfirm().equals(user.getNewPassword())) {
            result.rejectValue("passwordConfirm", "error.passwordConfirm", "Powtórz nowe hasło");
        }
        if (result.hasErrors()) {
            return "changePass";
        } else {
            loggedUser.setPassword(user.getNewPassword());
            loggedUser.setPasswordConfirm(user.getPasswordConfirm());
            userService.updateUser(loggedUser);
        }
        return "redirect:changePassCompleted";
    }

    @RequestMapping("/changepasscompleted")
    public String Completed() {
        return "changePassCompleted";
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

    @RequestMapping("/messages")
    public String Messages(Model model, HttpServletRequest servletRequest) {
        User loggedUser = userService.findByUserName(servletRequest.getRemoteUser());
        model.addAttribute("messages", messageService.findAllByUser(loggedUser));
        return "messages";
    }
}
