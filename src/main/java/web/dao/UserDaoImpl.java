package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u JOIN FETCH u.roles", User.class).getResultList();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        User u = findUserById(id);
        entityManager.remove(u);
    }

    @Override
    @Transactional
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByLogin(String login) {
        Query query = entityManager.createQuery("select u from User u JOIN FETCH u.roles where u.login = :login", User.class);
                query.setParameter("login", login);
        User result = null;
        try {
            result = (User) query.getSingleResult();
        } catch (NoResultException e) {
            // no result found
        }
        return result;
        //return entityManager.createQuery("select u from User u JOIN FETCH u.roles where u.login = :login", User.class)
        //        .setParameter("login", login)
        //        .getSingleResult();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

}
