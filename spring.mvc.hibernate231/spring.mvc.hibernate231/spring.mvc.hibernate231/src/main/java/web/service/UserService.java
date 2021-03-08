package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.entity.User;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    void saveUser(User user);

    void delete(Long id);

    User findUser(Long id);

    void update(User user);

    User findByUsername(String username);


}
