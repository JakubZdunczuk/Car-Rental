package pl.coderslab.carrental.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.carrental.car.*;
import pl.coderslab.carrental.user.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {
    private final UserService userService;
    private final CarService carService;
    private final BrandService brandService;
    private final CarModelService carModelService;

    public DashboardController(UserService userService, CarService carService, BrandService brandService, CarModelService carModelService) {
        this.userService = userService;
        this.carService = carService;
        this.brandService = brandService;
        this.carModelService = carModelService;
    }

    @RequestMapping()
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
    public String addNewCarPost(@Valid Car car, BindingResult bindingResult, Model model) {
        model.addAttribute("brandList", brandService.findAll());
  boolean found=false;
        if (bindingResult.hasErrors()) {
            return "addNewCar";
        }
        CarModel carModel = new CarModel();
        List<CarModel> carModelList = carModelService.findAll();
        for (CarModel cm : carModelList) {
            if (car.getModel().getModelName().equals(cm.getModelName()) && car.getModel().getBrand().equals(cm.getBrand())) {
                carModel.setId(cm.getId());
                carModel.setModelName(car.getModel().getModelName());
                carModel.setBrand(car.getModel().getBrand());
                car.setModel(carModel);
                carService.saveCar(car);
                found=true;
            }
        }
        if(!found){
            carModel.setModelName(car.getModel().getModelName());
            carModel.setBrand(car.getModel().getBrand());
            carModelService.saveCarModel(carModel);
            car.setModel(carModel);
            carService.saveCar(car);
        }

        return "redirect:confirm";
    }

    @RequestMapping("/confirm")
    public String Confirmation() {
        return "caradded";
    }


    @RequestMapping("/carlist")
    public String CarList(Model model) {
model.addAttribute("carlist", carService.findAll());
        return "carListEdit";
    }

    @RequestMapping("/messages")
    public String Messages(Model model) {

        return "messages";
    }

    @RequestMapping("/changepass")
    public String Change(Model model) {

        return "changepass";
    }

    @RequestMapping("/users")
    public String UserList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "UserList";
    }
}
