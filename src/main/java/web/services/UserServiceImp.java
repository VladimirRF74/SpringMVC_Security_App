package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Component
public class UserServiceImp implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    public void updateUser(Long id, User user) {
        userDao.updateUser(id, user);
    }
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
    public User findUserId(Long id) {
        return userDao.findUserId(id);
    }
    public User findUserByLogin(String login) {
        return userDao.findUserByLogin(login);
    }
}
