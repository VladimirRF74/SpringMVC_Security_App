package web.services;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    void updateUser(Long id, User user);
    void deleteUser(Long id);
    User findUserId(Long id);
    User findUserByLogin(String login);
}
