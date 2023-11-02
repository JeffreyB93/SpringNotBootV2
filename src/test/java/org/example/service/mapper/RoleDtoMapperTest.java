package org.example.service.mapper;

import org.example.model.Role;
import org.example.model.User;
import org.example.service.dto.RoleDto;
import org.example.service.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleDtoMapperTest {

    private RoleDtoMapper roleDtoMapper;

    @BeforeEach
    public void setUp() {
        roleDtoMapper = Mappers.getMapper(RoleDtoMapper.class);
    }


    @Test
    void toDtoTest() {
        Role role = new Role();
        role.setRoleName("qwe");
        RoleDto userDto = roleDtoMapper.toDto(role);
        assertEquals("qwe", userDto.getRoleName());
    }

    @Test
    void toEntityTest() {
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName("qwe");
        Role role = roleDtoMapper.toEntity(roleDto);
        assertEquals("qwe", role.getRoleName());
    }
}
