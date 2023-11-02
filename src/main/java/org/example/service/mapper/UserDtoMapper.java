package org.example.service.mapper;

import org.example.model.User;
import org.example.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDtoMapper {
    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    @Mapping(source = "name", target = "name")
    UserDto toDto(User user);

    @Mapping(source = "name", target = "name")
    User toEntity(UserDto userDto);

}
