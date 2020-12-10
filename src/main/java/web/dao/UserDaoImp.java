package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@EnableTransactionManagement
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void updateUser(Long id, User user) {
        User u = findUserId(id);
        u.setName(user.getName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        entityManager.merge(u);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User u = findUserId(id);
        entityManager.remove(u);
    }

    @Override
    @Transactional
    public User findUserId(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByLogin(String login) {
        return entityManager.createQuery("select u from User u where u.login = :login", User.class)
                .setParameter("login", login)
                .getSingleResult();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

}
