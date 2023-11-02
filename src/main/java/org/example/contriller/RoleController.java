package org.example.contriller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.RoleService;
import org.example.service.dto.RoleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;
    private final ObjectMapper mapper;

    public RoleController(RoleService roleService) {
        this.mapper = new ObjectMapper();
        this.roleService = roleService;
    }


    @GetMapping()
    public ResponseEntity<String> findAll() throws JsonProcessingException {
        List<RoleDto> rolesDto = roleService.findAll();
        String jsonString = mapper.writeValueAsString(rolesDto);
        return ResponseEntity.ok(jsonString);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) throws JsonProcessingException {
        RoleDto role = roleService.findById(id);
        String jsonString = mapper.writeValueAsString(role);
        return ResponseEntity.ok(jsonString);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody RoleDto roleDto) throws JsonProcessingException {
        RoleDto roleDtoSave = roleService.save(roleDto);
        String jsonString = mapper.writeValueAsString(roleDtoSave);
        return ResponseEntity.ok(jsonString);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        roleService.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
