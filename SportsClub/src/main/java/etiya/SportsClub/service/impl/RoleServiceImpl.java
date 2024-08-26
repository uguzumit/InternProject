package etiya.SportsClub.service.impl;

import etiya.SportsClub.dto.RoleDTO;
import etiya.SportsClub.entity.Role;
import etiya.SportsClub.repository.RoleRepository;
import etiya.SportsClub.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = modelMapper.map(roleDTO, Role.class);
        return modelMapper.map(roleRepository.save(role), RoleDTO.class);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(role -> modelMapper.map(role, RoleDTO.class))
                .toList();
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        return roleRepository.findById(id)
                .map(role -> modelMapper.map(role, RoleDTO.class))
                .orElse(null);
    }

    @Override
    public RoleDTO updateRole(Long id, RoleDTO role) {

        Optional<Role> resultRole = roleRepository.findById(id);

        if(resultRole.isPresent()) {
            resultRole.get().setRoleName(role.getRoleName());
            return modelMapper.map(roleRepository.save(resultRole.get()), RoleDTO.class);
        }
        return null;

    }

    @Override
    public Boolean deleteRole(Long id) {
        roleRepository.deleteById(id);
        return true;
    }

}
