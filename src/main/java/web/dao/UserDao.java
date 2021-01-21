package web.dao;

import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    void addUser(User user);
    Set<User> getAllUsers();
    void updateUser(User user);
    void deleteUserById(Long id);
    User findUserById(Long id);
    User findUserByLogin(String login);
    List<User> getAllUsersRoles();
}
