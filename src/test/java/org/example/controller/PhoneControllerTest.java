package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.contriller.PhoneController;
import org.example.service.PhoneService;
import org.example.service.dto.PhoneDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class PhoneControllerTest {

    @InjectMocks
    private PhoneController phoneController;
    @Mock
    private PhoneService phoneService;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAll() throws Exception {
        PhoneDto phoneDto1 = new PhoneDto();
        phoneDto1.setPhoneNumber("111");
        PhoneDto phoneDto2 = new PhoneDto();
        phoneDto2.setPhoneNumber("222");
        List<PhoneDto> phonesDto = List.of(phoneDto1, phoneDto2);
        Mockito.when(phoneService.findAll()).thenReturn(phonesDto);
        String jsonString = mapper.writeValueAsString(phonesDto);
        ResponseEntity<String> response = phoneController.findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jsonString, response.getBody());
    }

    @Test
    public void findById() throws Exception {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setPhoneNumber("111");
        Mockito.when(phoneService.findById(1L)).thenReturn(phoneDto);
        String jsonString = mapper.writeValueAsString(phoneDto);
        ResponseEntity<String> response = phoneController.findById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jsonString, response.getBody());
    }

    @Test
    public void save() throws Exception {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setPhoneNumber("111");
        Mockito.when(phoneService.save(phoneDto)).thenReturn(phoneDto);
        String jsonString = mapper.writeValueAsString(phoneDto);
        ResponseEntity<String> response = phoneController.save(phoneDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jsonString, response.getBody());
    }

    @Test
    public void delete() {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setPhoneNumber("111");
        ResponseEntity<Long> response = phoneController.delete(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody());
    }
}