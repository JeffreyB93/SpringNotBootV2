package org.example.service.impl;


import org.example.model.Phone;
import org.example.repository.PhoneRepository;

import org.example.service.dto.PhoneDto;
import org.example.service.mapper.PhoneDtoMapper;
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
class PhoneServiceImplTest {

    @InjectMocks
    private PhoneServiceImpl phoneService;
    @Mock
    private PhoneRepository phoneRepository;

    @Mock
    private PhoneDtoMapper phoneDtoMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findById() {
        Phone phone = new Phone();
        phone.setId(1L);
        phone.setPhoneNumber("888");
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setPhoneNumber("888");

        Mockito.when(phoneRepository.findById(1L)).thenReturn(Optional.of(phone));
        Assertions.assertEquals(phoneDto, phoneService.findById(1L));
    }

    @Test
    void deleteById() {
        Assertions.assertEquals(true, phoneService.deleteById(1L));
    }

    @Test
    void save() {
        Phone phone = new Phone();
        phone.setPhoneNumber("888");

        Phone phone1 = new Phone();
        phone1.setId(1L);
        phone1.setPhoneNumber("888");

        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setPhoneNumber("888");

        Mockito.when(phoneRepository.save(phone)).thenReturn(phone1);
        Assertions.assertEquals(phoneDto, phoneService.save(phoneDto));
    }

    @Test
    void findAll() {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setPhoneNumber("888");
        List<PhoneDto> rolesDto = new ArrayList<>(List.of(phoneDto));

        Phone phone = new Phone();
        phone.setPhoneNumber("888");
        List<Phone> phones = new ArrayList<>(List.of(phone));

        Mockito.when(phoneRepository.findAll()).thenReturn(phones);
        Assertions.assertEquals(rolesDto, phoneService.findAll());
    }
}