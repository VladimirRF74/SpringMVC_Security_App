package web.services;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
    User findUserById(Long id);
    User findUserByLogin(String login);
}
