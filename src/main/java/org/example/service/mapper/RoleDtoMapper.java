package org.example.service.mapper;

import org.example.model.Role;
import org.example.model.User;
import org.example.service.dto.RoleDto;
import org.example.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleDtoMapper {
    RoleDtoMapper INSTANCE = Mappers.getMapper(RoleDtoMapper.class);

    @Mapping(source = "roleName", target = "roleName")
    RoleDto toDto(Role role);

    @Mapping(source = "roleName", target = "roleName")
    Role toEntity(RoleDto roleDto);

}
