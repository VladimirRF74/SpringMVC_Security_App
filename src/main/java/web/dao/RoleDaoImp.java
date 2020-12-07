package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@EnableTransactionManagement
public class RoleDaoImp implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Role getId(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    @Transactional
    public Role getRole(String nameRole) {
        return entityManager.find(Role.class, nameRole);
    }
}
