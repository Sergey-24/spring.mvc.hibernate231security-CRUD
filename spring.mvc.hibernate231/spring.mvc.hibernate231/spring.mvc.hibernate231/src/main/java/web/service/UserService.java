package web.service;

import web.entity.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void delete(Long id);

    User findUser(Long id);

    void update(User user);

}
