package org.example.service.mapper;

import org.example.model.Phone;
import org.example.service.dto.PhoneDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhotoDtoMapperTest {

    private PhoneDtoMapper phoneDtoMapper;

    @BeforeEach
    public void setUp() {
        phoneDtoMapper = Mappers.getMapper(PhoneDtoMapper.class);
    }


    @Test
    void toDtoTest() {
        Phone phone = new Phone();
        phone.setPhoneNumber("8888");
        PhoneDto phoneDto = phoneDtoMapper.toDto(phone);
        assertEquals("8888", phoneDto.getPhoneNumber());
    }

    @Test
    void toEntityTest() {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setPhoneNumber("8888");
        Phone phone = phoneDtoMapper.toEntity(phoneDto);
        assertEquals("8888", phone.getPhoneNumber());
    }


}
