package org.example.service.impl;

import org.example.model.Role;
import org.example.repository.RoleRepository;
import org.example.service.dto.RoleDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @InjectMocks
    private RoleServiceImpl roleService;
    @Mock
    private RoleRepository roleRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findById() {
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("Админ");
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName("Админ");
        Mockito.when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
        Assertions.assertEquals(roleDto, roleService.findById(1L));
    }

    @Test
    void deleteById() {
        Assertions.assertEquals(true, roleService.deleteById(1L));
    }

    @Test
    void save() {
        Role role = new Role();
        role.setRoleName("Админ");
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName("Админ");
        Mockito.when(roleRepository.save(role)).thenReturn(role);
        Assertions.assertEquals(roleDto, roleService.save(roleDto));
    }

    @Test
    void findAll() {
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("Админ");
        List<Role> roles = new ArrayList<>(List.of(role));

        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName("Админ");
        List<RoleDto> rolesDto = new ArrayList<>(List.of(roleDto));

        Mockito.when(roleRepository.findAll()).thenReturn(roles);
        Assertions.assertEquals(rolesDto, roleService.findAll());
    }
}