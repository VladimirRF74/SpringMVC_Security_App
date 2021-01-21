package web.services;

import web.model.User;

import java.util.Set;

public interface UserService {
    void addUser(User user);
    Set<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
    User findUserById(Long id);
    User findUserByLogin(String login);
}
