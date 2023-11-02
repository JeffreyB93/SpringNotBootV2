package org.example.service.impl;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.dto.UserDto;
import org.junit.jupiter.api.Assertions;
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
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;

    @Test
    void findById() {
        User user = new User();
        user.setId(1L);
        user.setName("Коля");

        UserDto userDto = new UserDto();
        userDto.setName("Коля");

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Assertions.assertEquals(userDto, userService.findById(1L));
    }

    @Test
    void deleteById() {
        Assertions.assertEquals(userService.deleteById(1L), true);
    }

    @Test
    void save() {
        User user = new User();
        user.setName("Коля");
        UserDto userDto = new UserDto();
        userDto.setName("Коля");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertEquals(userDto, userService.save(userDto));
    }

    @Test
    void findAll() {
        User user = new User();
        user.setId(1L);
        user.setName("Коля");
        ArrayList<User> users = new ArrayList<>(List.of(user));
        UserDto userDto = new UserDto();
        userDto.setName("Коля");
        ArrayList<UserDto> usersDto = new ArrayList<>(List.of(userDto));
        Mockito.when(userRepository.findAll()).thenReturn(users);
        Assertions.assertEquals(usersDto, userService.findAll());
    }
}