package pl.coderslab.carrental.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.carrental.validator.PasswordEqual;
import pl.coderslab.carrental.validator.PasswordValidator;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @InitBinder("User")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators((Validator) new PasswordValidator());
    }

    private final UserService userService;
    private PasswordValidator passwordValidator;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveUser(user);
        return "admin";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid User user, BindingResult result) {
        List<User> userList = userService.findAll();

        for (User u : userList) {
            if (u.getUsername().equals(user.getUsername())) {

               result.rejectValue("username", "error.username","nazwa użytkownika już istnieje");
            }
            if (u.getEmail().equals(user.getEmail())) {
                result.rejectValue("email", "error.email", "email już został użyty");
            }
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            result.rejectValue("passwordConfirm", "error.passwordConfirm","hasła nie są zgodne!");
        }

        if (result.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/registrationCompleted";
    }
    @GetMapping("/registrationCompleted")
    public String regComplete(){

        return "registrationCompleted";
    }
}
