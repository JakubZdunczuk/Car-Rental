package pl.coderslab.car_longrental.users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final EntityManager entityManager;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(EntityManager entityManager, UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.entityManager = entityManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByUserName(String username) {

        return userRepository.findByUsername(username);
    }
    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }
}

