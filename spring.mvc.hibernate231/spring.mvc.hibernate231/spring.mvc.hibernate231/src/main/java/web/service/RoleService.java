package web.service;


import web.entity.Role;
import java.util.Set;

public interface RoleService {
    Set<Role> getRoles(Set<String> role);

    Set<Role> findAllRoles();

}
