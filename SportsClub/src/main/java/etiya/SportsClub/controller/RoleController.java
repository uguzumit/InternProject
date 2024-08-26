package etiya.SportsClub.controller;

import etiya.SportsClub.dto.RoleDTO;
import etiya.SportsClub.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/register")
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO role) {
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @GetMapping("/list")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable("id") Long id, @RequestBody RoleDTO role) {
        return ResponseEntity.ok(roleService.updateRole(id, role));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteRole(@PathVariable("id") Long id) {
        return ResponseEntity.ok(roleService.deleteRole(id));
    }

}
