package pl.coderslab.car_longrental.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Scanner;

@Controller
public class UserController {

    private final UserService userService;

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
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(User user){
        //do uzupełnienia

        boolean check = false;
        List<User> userList=userService.findAll();
        for (User u: userList) {
            if(user.getUsername().equals(u.getUsername())){
                check=true;
                break;
            }
        };
        if(!check){
            userService.saveUser(user);
            return "registrationCompleted";
        }else{
//nazwa użytkownika istnieje, wybierz inną
        }
        return "register";
    }

}
