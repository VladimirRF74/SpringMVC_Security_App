package web.dao;

import web.model.Role;

public interface RoleDao {
    Role getId(Long id);
    Role getRole(String nameRole);
}
