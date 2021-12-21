package pl.coderslab.car_longrental.users;

import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);

    List<User> findAll();

    User findById(long id);
}

