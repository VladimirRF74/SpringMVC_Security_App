package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUserById(Long id);
    User findUserById(Long id);
    User findUserByLogin(String login);
}
