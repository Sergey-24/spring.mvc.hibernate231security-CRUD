package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.entity.Role;

import java.util.Set;


@Service
public class RoleServiceImpl implements RoleService {

   RoleDao roleDao;

   @Autowired
   public void setRoleDao(RoleDao roleDao) {
      this.roleDao = roleDao;
   }

   @Override
   public Set<Role> getRoles(Set<String> role) {
      return roleDao.getRoles(role);
   }

   @Override
   public Set<Role> findAllRoles() {
      return roleDao.findAllRoles();
   }


}
