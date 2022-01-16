package pl.coderslab.carrental.user;

import java.util.List;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);

    List<User> findAll();

    User findById(long id);

    void updateUser(User user);
}

