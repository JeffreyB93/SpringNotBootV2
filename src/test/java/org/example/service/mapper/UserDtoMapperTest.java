package org.example.service.mapper;

import org.example.model.Phone;
import org.example.model.User;
import org.example.service.dto.PhoneDto;
import org.example.service.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDtoMapperTest {

    private UserDtoMapper userDtoMapper;

    @BeforeEach
    public void setUp() {
        userDtoMapper = Mappers.getMapper(UserDtoMapper.class);
    }


    @Test
    void toDtoTest() {
        User user = new User();
        user.setName("qwe");
        UserDto userDto = userDtoMapper.toDto(user);
        assertEquals("qwe", userDto.getName());
    }

    @Test
    void toEntityTest() {
        UserDto userDto = new UserDto();
        userDto.setName("qwe");
        User user = userDtoMapper.toEntity(userDto);
        assertEquals("qwe", user.getName());
    }
}
