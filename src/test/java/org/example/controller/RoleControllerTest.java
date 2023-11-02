package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.contriller.PhoneController;
import org.example.contriller.RoleController;
import org.example.service.PhoneService;
import org.example.service.RoleService;
import org.example.service.dto.PhoneDto;
import org.example.service.dto.RoleDto;
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
public class RoleControllerTest {

    @InjectMocks
    private RoleController roleController;
    @Mock
    private RoleService roleService;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAll() throws Exception {
        RoleDto roleDto1 = new RoleDto();
        roleDto1.setRoleName("Админ");
        RoleDto roleDto2 = new RoleDto();
        roleDto2.setRoleName("Клиент");
        List<RoleDto> rolesDto = List.of(roleDto1, roleDto2);
        Mockito.when(roleService.findAll()).thenReturn(rolesDto);
        String jsonString = mapper.writeValueAsString(rolesDto);
        ResponseEntity<String> response = roleController.findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jsonString, response.getBody());
    }

    @Test
    public void findById() throws Exception {
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName("Админ");
        Mockito.when(roleService.findById(1L)).thenReturn(roleDto);
        String jsonString = mapper.writeValueAsString(roleDto);
        ResponseEntity<String> response = roleController.findById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jsonString, response.getBody());
    }

    @Test
    public void save() throws Exception {
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName("Админ");
        Mockito.when(roleService.save(roleDto)).thenReturn(roleDto);
        String jsonString = mapper.writeValueAsString(roleDto);
        ResponseEntity<String> response = roleController.save(roleDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jsonString, response.getBody());
    }

    @Test
    public void delete() {
        ResponseEntity<Long> response = roleController.delete(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody());
    }
}