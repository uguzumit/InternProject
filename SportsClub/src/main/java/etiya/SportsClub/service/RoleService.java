package etiya.SportsClub.service;

import etiya.SportsClub.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    RoleDTO createRole(RoleDTO role);
    List<RoleDTO> getAllRoles();
    RoleDTO getRoleById(Long id);
    RoleDTO updateRole(Long id, RoleDTO role);
    Boolean deleteRole(Long id);

}
