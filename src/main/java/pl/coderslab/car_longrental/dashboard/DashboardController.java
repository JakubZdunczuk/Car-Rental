package pl.coderslab.car_longrental.dashboard;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/dashboard")
public class DashboardController {

    @RequestMapping("/add")
    public String addNewCar() {
        return "dashboard/addNewCar";
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
