package etiya.SportsClub.service.impl;

import etiya.SportsClub.entity.Role;
import etiya.SportsClub.repository.RoleRepository;
import etiya.SportsClub.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteRole(Long id) {
        Role existingRole = roleRepository.findById(id).orElse(null);
        if (existingRole == null) {
            return false;
        }
        roleRepository.delete(existingRole);
        return true;
    }

}
