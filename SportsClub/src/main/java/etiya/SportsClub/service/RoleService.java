package etiya.SportsClub.service;

import etiya.SportsClub.entity.Role;

import java.util.List;

public interface RoleService {

    Role createRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Boolean deleteRole(Long id);

}
