package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.model.User;

import java.util.Optional;
import java.util.Set;

@Component
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        String n = user.getName();
        String ln = user.getLastName();
        String l = user.getLogin();
        if (n != null & ln != null & l != null) {
            userDao.addUser(user);
        }
    }
    public Set<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    public void deleteUser(Long id) {
        userDao.deleteUserById(id);
    }
    public User findUserById(Long id) {
        return Optional.ofNullable(userDao.findUserById(id)).orElseThrow(NullPointerException::new);
    }
    public User findUserByLogin(String login) {
        return Optional.ofNullable(userDao.findUserByLogin(login)).orElseThrow(NullPointerException::new);
    }
}
