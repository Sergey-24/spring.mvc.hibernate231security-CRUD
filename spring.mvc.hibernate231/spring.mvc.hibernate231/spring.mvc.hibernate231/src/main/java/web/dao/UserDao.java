package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import web.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    void delete(Long id);

    User findUser(Long id);

    void update(User user);

    User findByUsername(String name);
}
