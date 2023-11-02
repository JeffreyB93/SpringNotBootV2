package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.contriller.UserController;
import org.example.service.UserService;
import org.example.service.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAll() throws Exception {
        UserDto userDto1 = new UserDto();
        userDto1.setName("Коля");
        UserDto userDto2 = new UserDto();
        userDto2.setName("Катя");
        List<UserDto> usersDto = List.of(userDto1, userDto2);
        Mockito.when(userService.findAll()).thenReturn(usersDto);
        String jsonString = mapper.writeValueAsString(usersDto);
        ResponseEntity<String> response = userController.findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jsonString, response.getBody());
    }

    @Test
    public void findById() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setName("111");
        Mockito.when(userService.findById(1L)).thenReturn(userDto);
        String jsonString = mapper.writeValueAsString(userDto);
        ResponseEntity<String> response = userController.findById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jsonString, response.getBody());
    }

    @Test
    public void save() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setName("Админ");
        Mockito.when(userService.save(userDto)).thenReturn(userDto);
        String jsonString = mapper.writeValueAsString(userDto);
        ResponseEntity<String> response = userController.save(userDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jsonString, response.getBody());
    }

    @Test
    public void delete() {
        ResponseEntity<Long> response = userController.delete(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody());
    }
}