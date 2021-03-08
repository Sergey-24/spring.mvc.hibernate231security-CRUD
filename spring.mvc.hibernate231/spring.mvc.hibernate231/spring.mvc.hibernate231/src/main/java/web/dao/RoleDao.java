package web.dao;

import web.entity.Role;
import web.entity.User;

import java.util.Set;

public interface RoleDao {

    Set<Role> getRoles(Set<String> role);

    Set<Role> findAllRoles();

}
