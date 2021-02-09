package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);
}
